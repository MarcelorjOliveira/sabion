package br.com.sabion.client.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sabion.client.model.Usuario;
import br.com.sabion.client.repository.UsuarioRepository;

@Controller
public class UploadController {

	@Autowired
	private UsuarioRepository userRepository;

    @RequestMapping("/uploadsingle")
    public String index() {
        return Routes.uploadMain;
    }
    
    @RequestMapping(Routes.uploadForm)
    public String upload() {
        return Routes.uploadForm;
    }
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String singleFileUpload(@RequestParam("foto") MultipartFile file,
                                   RedirectAttributes redirectAttributes,
                                   HttpServletRequest request) {
    	//testar system out println
    	System.out.println("Diretorio:");
/*
curl -F 'file=@/home/computador/Pictures/mastro.png' http://localhost/upload?token=4829448E-BAB4-4E59-B6A3-9C996B72DB71
curl --cookie-jar newcookies.txt -F 'file=@/home/computador/Pictures/caso.png' http://localhost/upload
 */
    	String token = request.getParameter("token");

		Usuario usuario = userRepository.findByToken(token).get();

		if(usuario != null) {
		
			String userId = Long.toString(usuario.getId());    	
	    	
			String diretorio =  Usuario.initialDirectory + userId + "/" + "gallery/";
	    	
	        if (file.isEmpty()) {
	            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
	            return "redirect:uploadStatus";
	        }
	
	        try {
	    		File fileDirectory = new File(diretorio);
	        	
	    		fileDirectory.mkdirs();
	    		
	        	// Get the file and save it somewhere
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(diretorio + file.getOriginalFilename());
	            Files.write(path, bytes);
	
	            redirectAttributes.addFlashAttribute("message", 
	                        "You successfully uploaded '" + file.getOriginalFilename() + "'");
	
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}

        return "redirect:/uploadStatus";
    }

    @RequestMapping("/uploadStatus")
    public String uploadStatus() {
        return "/main/uploadStatus";
    }

}
