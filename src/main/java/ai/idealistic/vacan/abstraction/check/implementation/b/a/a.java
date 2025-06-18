package ai.idealistic.vacan.abstraction.check.implementation.b.a;

import ai.idealistic.vacan.abstraction.check.Check;
import org.bukkit.Location;

public class a extends ai.idealistic.vacan.abstraction.check.b {
   private ai.idealistic.vacan.utils.minecraft.d.b cA = new ai.idealistic.vacan.utils.minecraft.d.b(0.0F, 0.0F);
   private ai.idealistic.vacan.utils.minecraft.d.b cB = new ai.idealistic.vacan.utils.minecraft.d.b(0.0F, 0.0F);
   private float cC = 0.0F;
   private int aE = 0;

   a(ai.idealistic.vacan.abstraction.check.e var1) {
      super(var1, Check.DataType.JAVA, (Check.DetectionType)null, "baritone", true);
   }

   void run() {
      this.a(() -> {
         Location var1 = this.ac.getLocation();
         ai.idealistic.vacan.utils.minecraft.d.b var2 = new ai.idealistic.vacan.utils.minecraft.d.b(var1.getYaw(), var1.getPitch());
         float var3 = (float)ai.idealistic.vacan.utils.b.f.l((double)Math.abs(var2.lP - this.cA.lP), 3.0D);
         float var4 = (float)ai.idealistic.vacan.utils.b.f.l((double)Math.abs(var2.lQ - this.cA.lQ), 3.0D);
         ai.idealistic.vacan.utils.minecraft.d.b var5 = new ai.idealistic.vacan.utils.minecraft.d.b(var3, var4);
         if (this.ac.cg() == null) {
            this.cC += Math.abs(var1.getPitch()) > 89.0F ? 0.0F : (var4 == 0.0F ? var3 : -this.cC);
            this.cC = (float)ai.idealistic.vacan.utils.b.f.l((double)this.cC, 2.0D);
            if (this.cC > 45.0F && Math.abs((double)this.cC % 360.0D - 1.0D) < 1.0E-9D) {
               this.aE += 3;
               if (this.aE > 14) {
                  this.a(3, "baritone[rotation], euler-y-total: " + this.cC);
               }
            }

            if (this.aE > 0) {
               --this.aE;
            }

            this.cA = var2;
            this.cB = var5;
         }
      });
   }

   void P() {
      this.a(() -> {
         this.cC = 0.0F;
      });
   }

   private void a(int var1, String var2) {
      this.aE += var1;
      if (this.aE > 10) {
         this.c(var2);
         this.aE -= 4;
      }

   }
}
