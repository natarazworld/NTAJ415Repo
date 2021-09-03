function  validate(frm){
    	//empty the form validation error messages
    	document.getElementById("pnameErr").innerHTML="";
    	document.getElementById("paddrsErr").innerHTML="";
    	document.getElementById("pageErr").innerHTML="";
    	//read form data
    	let  name=frm.pname.value;
    	let addrs=frm.paddrs.value;
    	let  age=frm.page.value;
    	//client side form validations
    	let flag=true;
    	if(name==""){  //required rule on person name
    		document.getElementById("pnameErr").innerHTML="Person name is required";
    		frm.pname.focus();
    		flag=false;
    	}
    	if(addrs==""){  //required rule on person address
    		document.getElementById("paddrsErr").innerHTML="Person address is required";
    		frm.paddrs.focus();
    		flag=false;
    	}
    	else if(addrs.length<10){  //minlength rule on person address
    		document.getElementById("paddrsErr").innerHTML=" person address  must have minimun of 10 chars";
    		frm.paddrs.focus();  //makes text box gaining the focus (cursor goes there)
    		flag=false;
    	}
    	
    	if(age==""){  //  ruquired rule on person page
    		document.getElementById("pageErr").innerHTML=" person age is required";
    		frm.page.focus();
    		flag=false;
    	}
    	else if(isNaN(age)){  // must be numeric value rule on person age
    		document.getElementById("pageErr").innerHTML=" person age is must be numeric value";
    		frm.page.focus();
    		flag=false;
    	}
    	else if(age<=0 || age>125) {  // range rule on Person age
    		document.getElementById("pageErr").innerHTML=" person age must be there between 1 through 125";
    		frm.page.focus();
    		flag=false;
    	}
         //change hidden box value (vflag) to "yes" indicating client side form validations are done
          frm.vflag.value="yes";
    	return flag;
    }//function