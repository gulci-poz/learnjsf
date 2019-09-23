package learnjsf;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("sampleViewBean")
@ViewScoped
public class SampleViewScopedBean implements Serializable {

    private List<String> dogs;

    public List<String> getDogs() {
        return dogs;
    }

    public void setDogs(List<String> dogs) {
        this.dogs = dogs;
    }

    @PostConstruct
    public void initDogs() {
        dogs = new ArrayList<>();
        dogs.add("corgi");
        dogs.add("retriever");
    }

    @PreDestroy
    public void cleanUp() {
        dogs.clear();
    }

    public void getSession() {
        // if there's no session, no new session is created (false)
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        // logout or page timeout
        session.invalidate();
    }

    public boolean isRefreshed() {
        // context is per page
        return FacesContext.getCurrentInstance().isPostback();
        //FacesContext.getCurrentInstance().validationFailed();
    }
}
