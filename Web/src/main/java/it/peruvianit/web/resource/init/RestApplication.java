package it.peruvianit.web.resource.init;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import static it.peruvianit.web.constant.WebConstant.VERSION_WEB_API_REST;;

@ApplicationPath("/" + VERSION_WEB_API_REST + "/")
public class RestApplication extends Application {
}
