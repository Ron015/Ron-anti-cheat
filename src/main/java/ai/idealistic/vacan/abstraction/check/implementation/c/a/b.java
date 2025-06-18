package ai.idealistic.vacan.abstraction.check.implementation.c.a;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.e;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

public class b extends ai.idealistic.vacan.abstraction.check.b {
   private Block ex;
   private long ey = System.currentTimeMillis();
   private long ez = 0L;
   private final ai.idealistic.vacan.abstraction.b.a.b eA = new ai.idealistic.vacan.abstraction.b.a.b();

   b(e var1) {
      super(var1, (Check.DataType)null, (Check.DetectionType)null, "scaffold_analysis", true);
   }

   void b(Block var1) {
      this.a(() -> {
         ai.idealistic.vacan.abstraction.f.c var2 = this.ac;
         if (this.ex == null) {
            this.ex = var1;
         } else {
            Location var3 = var2.getLocation();
            Location var4 = new Location(var3.getWorld(), (double)((long)var3.getX()), (double)((long)var3.getY()), (double)((long)var3.getZ()));
            long var5 = (long)(var4.getX() * 31.0D + var4.getZ());
            Location var7 = var1.getLocation();
            Block var8 = this.ex;
            Material var9 = (new ai.idealistic.vacan.abstraction.g.b(var7.clone().add(0.0D, -1.0D, 0.0D))).dO().dA();
            long var10 = System.currentTimeMillis() - this.ey;
            boolean var12 = false;
            boolean var13 = true;
            List var14 = Arrays.asList((long)(var7.getX() * 31.0D + var7.getZ()), (long)((var7.getX() + 0.3D) * 31.0D + var7.getZ()), (long)((var7.getX() - 0.3D) * 31.0D + var7.getZ()), (long)(var7.getX() * 31.0D + var7.getZ() + 0.3D), (long)(var7.getX() * 31.0D + (var7.getZ() - 0.3D)), (long)((var7.getX() + 0.3D) * 31.0D + var7.getZ() + 0.3D), (long)((var7.getX() + 0.3D) * 31.0D + (var7.getZ() - 0.3D)), (long)((var7.getX() - 0.3D) * 31.0D + var7.getZ() + 0.3D), (long)((var7.getX() - 0.3D) * 31.0D + (var7.getZ() - 0.3D)));
            Iterator var15 = var14.iterator();

            while(var15.hasNext()) {
               Long var16 = (Long)var15.next();
               if (var2.bI()) {
                  if (var16 != var5 && !(ai.idealistic.vacan.abstraction.g.b.b(var7, var3) < 1.2D)) {
                     if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
                        continue;
                     }

                     Vector var17 = var4.toVector().clone();
                     Vector var18 = var7.toVector().clone();
                     if (var18.getX() != var17.getX() - 1.0D || var18.getZ() != var17.getZ()) {
                        continue;
                     }

                     var12 = true;
                     break;
                  }

                  var12 = true;
                  break;
               } else if (ai.idealistic.vacan.abstraction.g.b.b(var7, var3) < 2.35D) {
                  var12 = true;
                  break;
               }
            }

            if (var10 >= 5L && var5 != this.ez && !((double)((long)var2.getLocation().getY()) <= var7.getY()) && !var2.bC().isFlying() && var12) {
               ai.idealistic.vacan.abstraction.b.a.b var10000;
               if (var7.getY() == var8.getLocation().getY() && ai.idealistic.vacan.utils.minecraft.world.c.S(var9)) {
                  if (var10 < 280L) {
                     var10000 = this.eA;
                     var10000.eO += 4;
                  } else if (var10 < (long)(var2.bL() ? 345 : 385) && var2.gl < 3) {
                     var10000 = this.eA;
                     var10000.eO += 2;
                  } else {
                     var13 = false;
                  }

                  if (this.eA.eO > 12 && var13) {
                     this.c("scaffold analysis (" + (long)Math.abs(400.0D / (double)var10 * 100.0D - 100.0D) + "% faster than possible) [VL: " + this.eA.eO + "]");
                     this.eA.eO = 10;
                  } else if (this.eA.eO > 0) {
                     var10000 = this.eA;
                     var10000.eO -= 2;
                  }

                  this.ex = var1;
                  this.ez = var5;
                  this.ey = System.currentTimeMillis();
                  var2.gl = 0;
               } else {
                  var2.gl = 0;
                  this.ex = var1;
                  if (this.eA.eO > 5) {
                     var10000 = this.eA;
                     var10000.eO -= 5;
                  }

               }
            } else {
               var2.gl = 0;
               this.ey = System.currentTimeMillis();
               this.ex = var1;
            }
         }
      });
   }
}
