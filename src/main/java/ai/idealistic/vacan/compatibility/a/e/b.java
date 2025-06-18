package ai.idealistic.vacan.compatibility.a.e;

import ai.idealistic.vacan.abstraction.b.c;
import ai.idealistic.vacan.compatibility.Compatibility;
import es.pollitoyeye.vehicles.enums.VehicleType;
import es.pollitoyeye.vehicles.events.VehicleEnterEvent;
import es.pollitoyeye.vehicles.events.VehicleExitEvent;
import java.util.LinkedHashMap;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class b implements Listener {
   private static final c fN = new c(new ai.idealistic.vacan.utils.a.c(new LinkedHashMap(), 512));
   private static final String key;
   public static final String hz = "drill";
   public static final String hA = "tractor";
   private static final String[] hB;

   @EventHandler(
      priority = EventPriority.HIGHEST,
      ignoreCancelled = true
   )
   private void a(VehicleEnterEvent var1) {
      if (Compatibility.CompatibilityType.VEHICLES.isFunctional()) {
         ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.i(var1.getPlayer());
         VehicleType var3 = var1.getVehicleType();
         if (var3 == VehicleType.DRILL) {
            c(var2, "drill");
         } else if (var3 == VehicleType.TRACTOR) {
            c(var2, "tractor");
         }
      }

   }

   @EventHandler(
      priority = EventPriority.HIGHEST,
      ignoreCancelled = true
   )
   private void a(VehicleExitEvent var1) {
      if (Compatibility.CompatibilityType.VEHICLES.isFunctional()) {
         ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.i(var1.getPlayer());
         String[] var3 = hB;
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            String var6 = var3[var5];
            fN.u(b(var2, var6));
         }
      }

   }

   private static String b(ai.idealistic.vacan.abstraction.f.c var0, String var1) {
      return var0.bT() + "=" + key + var1;
   }

   private static void c(ai.idealistic.vacan.abstraction.f.c var0, String var1) {
      fN.g(b(var0, var1), 20);
   }

   public static boolean d(ai.idealistic.vacan.abstraction.f.c var0, String var1) {
      return !fN.t(b(var0, var1));
   }

   public static boolean a(ai.idealistic.vacan.abstraction.f.c var0, String[] var1) {
      String[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         if (d(var0, var5)) {
            return true;
         }
      }

      return false;
   }

   static {
      key = Compatibility.CompatibilityType.VEHICLES + "=compatibility=";
      hB = new String[]{"drill", "tractor"};
   }
}
