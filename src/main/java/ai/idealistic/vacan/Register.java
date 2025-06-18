package ai.idealistic.vacan;

import ai.idealistic.vacan.functionality.c.a;
import ai.idealistic.vacan.functionality.connection.d;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import ai.idealistic.vacan.listeners.a.a.b;
import ai.idealistic.vacan.listeners.a.a.c;
import ai.idealistic.vacan.listeners.a.a.e;
import ai.idealistic.vacan.listeners.a.a.f;
import ai.idealistic.vacan.listeners.a.a.g;
import ai.idealistic.vacan.listeners.a.a.h;
import ai.idealistic.vacan.listeners.a.a.i;
import ai.idealistic.vacan.listeners.a.a.j;
import ai.idealistic.vacan.listeners.a.a.k;
import java.util.LinkedHashSet;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Register extends JavaPlugin {
   public static Plugin plugin = null;
   public static final String pluginName = "Vacan";
   public static final String command = "vacan";
   private static final Set<Class<?>> listeners = new LinkedHashSet(2);

   public void onEnable() {
      loadConfig0();
      plugin = this;
      if (MultiVersion.jf == MultiVersion.MCVersion.OTHER) {
         a.M("The server's version or type is not supported. Please contact the plugin's developer if you think this is an error.");
         Bukkit.getPluginManager().disablePlugin(this);
      } else {
         d.a(this);
         ai.idealistic.vacan.functionality.server.a.ay();
         ai.idealistic.vacan.functionality.server.a.iZ.aL();
         enable(new g());
         enable(new h());
         enable(new b());
         enable(new i());
         enable(new f());
         enable(new ai.idealistic.vacan.listeners.a.a.a());
         enable(new c());
         enable(new j());
         enable(new e());
         enable(new ai.idealistic.vacan.listeners.a.a());
         enable(new ai.idealistic.vacan.listeners.a.d());
         enable(new ai.idealistic.vacan.listeners.a.c());
         enable(new ai.idealistic.vacan.listeners.a.e());
         enable(new ai.idealistic.vacan.listeners.a.b());
         enable(new ai.idealistic.vacan.listeners.a.g());
         enable(new ai.idealistic.vacan.listeners.a.h());
         enable(new k());
         if (ai.idealistic.vacan.listeners.a.jL) {
            enable(new ai.idealistic.vacan.listeners.a());
         }

         if (ai.idealistic.vacan.utils.minecraft.entity.d.kX) {
            enable(new ai.idealistic.vacan.listeners.a.a.d());
            if (ai.idealistic.vacan.utils.minecraft.entity.d.dl) {
               enable(new ai.idealistic.vacan.listeners.a.f());
            }
         }

         ai.idealistic.vacan.utils.minecraft.c.c.fG();
         this.getCommand("vacan").setExecutor(new ai.idealistic.vacan.functionality.a.a());
         this.getCommand("vacan").setTabCompleter(new ai.idealistic.vacan.functionality.a.b());
      }
   }

   public void onDisable() {
      plugin = this;
      ai.idealistic.vacan.utils.minecraft.c.c.fH();
      listeners.clear();
      ai.idealistic.vacan.functionality.server.c.eB();
   }

   public static void enable(Listener var0) {
      if (isPluginEnabled() && listeners.add(var0.getClass())) {
         Bukkit.getPluginManager().registerEvents(var0, plugin);
      }

   }

   public static boolean isPluginEnabled() {
      return plugin != null && plugin.isEnabled();
   }
}
