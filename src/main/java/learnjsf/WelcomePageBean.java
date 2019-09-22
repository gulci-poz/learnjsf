package learnjsf;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("welcomePageBean")
@RequestScoped
public class WelcomePageBean {

    private String welcomeUserName;
    private String completedGreeting;

    public String getWelcomeUserName() {
        return welcomeUserName;
    }

    public void setWelcomeUserName(String welcomeUserName) {
        this.welcomeUserName = welcomeUserName;
    }

    public String getCompletedGreeting() {
        return completedGreeting;
    }

    public void setCompletedGreeting(String completedGreeting) {
        this.completedGreeting = completedGreeting;
    }

    public void sayHello() {
        completedGreeting = "Hello, " + welcomeUserName;
    }

    public String navigateToFlashPage() {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("transmittedVariable", "hello flashscope");
        return "flashscope.xhtml";
    }
}
