package com.csc280.FantasyWorldLab2;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class MyAdminController {
	
	private UserDetailsManager udm;
	private PasswordEncoder pswdEnc = null;
	
	public MyAdminController(UserDetailsManager ud,PasswordEncoder enc) {
		System.out.println("In myAdminControler :: M4AdminController()");
		this.udm = ud;
		this.pswdEnc = enc;
	}
    
    @RequestMapping(path="/index", method=RequestMethod.GET)
    public String speak() {
        return "M4 Admin Controller";
    }
    
    @RequestMapping(path="/newUser/{userName}/{Password}/{Role}", method=RequestMethod.GET)
    	public String say(@PathVariable String userName,@PathVariable String Password,@PathVariable String Role) {
    UserDetails newUser = User.withUsername(userName)
    		.password(pswdEnc.encode(Password))
    		.roles(Role).build();
    			M2Security.memAuth.createUser(newUser);
    			return "User created. Username: " + userName + " Password: " + Password + " Role: " + Role;     
    			}
    }


