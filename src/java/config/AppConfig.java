package config;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import controller.LoginController;
import model.Administrator;

public class AppConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        constants.setDevMode(true);
        constants.setEncoding("UTF-8");
        constants.setViewType(ViewType.FREE_MARKER);
        PropKit.use("config.properties");
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add("/login", LoginController.class);
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {
        C3p0Plugin cp=new C3p0Plugin(PropKit.get("jdbcUrl"),PropKit.get("user"),PropKit.get("password").trim());
        plugins.add(cp);
        ActiveRecordPlugin arp=new ActiveRecordPlugin(cp);
        plugins.add(arp);

        arp.addMapping("administrator","admin_id",Administrator.class);
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }

    //启动JFinal
    public static void main(String[] args) {
        JFinal.start("src/main/webapp", 80, "/");
    }
}
