package ai.idealistic.vacan.abstraction.check.implementation.combat.killaura;

import ai.idealistic.vacan.abstraction.check.Check;
import org.bukkit.Location;

public class d extends ai.idealistic.vacan.abstraction.check.b {
   private static final double be = Math.pow(2.0D, 24.0D);
   private static final double bf = 16384.0D;
   private static final double bg = 0.005D;
   private static final double bh = 0.001D;
   private Float bi = 0.0F;
   private Float bj = 0.0F;
   private final ai.idealistic.vacan.abstraction.b.a.a bk = new ai.idealistic.vacan.abstraction.b.a.a();
   private final ai.idealistic.vacan.abstraction.b.a.a bl = new ai.idealistic.vacan.abstraction.b.a.a();
   private long bm;
   private long bn;

   d(ai.idealistic.vacan.abstraction.check.e var1) {
      super(var1, Check.DataType.JAVA, Check.DetectionType.PACKETS, "move_length", true, 2000L, 30000L, 40000L, 60000L);
   }

   void run() {
      this.a(() -> {
         if (this.bm - System.currentTimeMillis() <= 2000L && this.bn - System.currentTimeMillis() <= 1000L) {
            float var1 = this.ac.getLocation().getPitch();
            float var2 = Math.abs(var1 - this.bi);
            if ((double)var2 > 0.0D && (double)this.bj > 0.0D) {
               double var3 = ai.idealistic.vacan.utils.b.a.g(16384.0D, (double)var2 * be, (double)this.bj * be) / be;
               if (var3 <= 0.005D) {
                  boolean var5 = var3 <= 0.001D;
                  ai.idealistic.vacan.abstraction.b.a.a var6 = var5 ? this.bl : this.bk;
                  if (var6.a(1.0D, 20) >= (double)(var5 ? 5 : 13)) {
                     var6.aO();
                     this.a("move-length, pitch: " + var1 + ", previous-pitch: " + this.bi + ", pitch-difference: " + var2 + ", previous-pitch-difference: " + this.bj + ", greatest-common-divisor: " + var3 + ", limit: " + 0.005D, (Location)null, ai.idealistic.vacan.utils.b.a.B(20.0D));
                  }
               } else {
                  this.bk.r(1.0D);
               }
            }

            this.bj = var2;
            this.bi = var1;
         }

      });
   }

   void z() {
      this.a(() -> {
         this.bm = System.currentTimeMillis();
      });
   }

   void A() {
      this.a(() -> {
         this.bn = System.currentTimeMillis();
      });
   }
}
