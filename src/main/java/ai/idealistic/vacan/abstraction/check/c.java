package ai.idealistic.vacan.abstraction.check;

import org.bukkit.Location;

public class c {
   boolean V = false;
   private final Location W;
   private final boolean aa;
   private final double ab;
   private final long t;

   c() {
      this.W = null;
      this.aa = false;
      this.ab = 0.0D;
      this.t = 0L;
   }

   c(Location var1, int var2, boolean var3, double var4) {
      this.W = var1;
      this.aa = var3 && ai.idealistic.vacan.functionality.server.a.iZ.i("Detections.ground_teleport_on_detection");
      this.ab = ai.idealistic.vacan.functionality.server.a.iZ.i("Detections.damage_on_detection") ? var4 : 0.0D;
      this.t = var2 <= 1 ? Long.MAX_VALUE : System.currentTimeMillis() + (long)var2 * 50L;
   }

   boolean k() {
      return this.V && System.currentTimeMillis() <= this.t;
   }

   boolean l() {
      return this.W != null || this.aa || this.ab > 0.0D;
   }

   void a(b var1) {
      if (ai.idealistic.vacan.functionality.server.c.fe()) {
         var1.a(this.W, this.aa, this.ab).run();
      } else {
         ai.idealistic.vacan.functionality.server.c.b(var1.ac, var1.a(this.W, this.aa, this.ab));
      }

   }
}
