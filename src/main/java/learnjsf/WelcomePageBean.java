package learnjsf;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Named("welcomePageBean")
@RequestScoped
public class WelcomePageBean {

    private String welcomeUserName;
    private String completedGreeting;

    // inject wider scoped to narrower scoped, for example application to session

    @Inject
    private SampleViewScopedBean viewBean;

    @Inject
    private HttpSession session;

    @Inject
    private ServletContext servContext;

    @Inject
    private Principal currentUser;

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

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public ServletContext getServContext() {
        return servContext;
    }

    public void setServContext(ServletContext servContext) {
        this.servContext = servContext;
    }

    public Principal getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Principal currentUser) {
        this.currentUser = currentUser;
    }

    public void sayHello() {
        completedGreeting = "Hello, " + welcomeUserName;
    }

    public String navigateToFlashPage() {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("transmittedVariable", viewBean.getDogs().get(0));
        return "flashscope.xhtml?faces-redirect=true";
    }
}
