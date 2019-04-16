@RequestMapping(value = "/register", method = RequestMethod.GET)
public String showRegistrationForm(Model model){
        model.addAttribute("student",new Student());
        return"form/registerForm";}

@RequestMapping(value = "/register", method = RequestMethod.GET)
public String showRegistrationForm(Model model){
        Student student=new Student("Jan","Kowalski");
        model.addAttribute("student",student);
        return"form/registerForm";}
