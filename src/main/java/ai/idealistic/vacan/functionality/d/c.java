package ai.idealistic.vacan.functionality.d;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

public class c {
   private static final double jD = 3.0D;
   private static final double jE = 2.0D;

   public static void a(Block var0, List<Block> var1) {
      Collection var2 = ai.idealistic.vacan.functionality.server.c.fc();
      if (!var2.isEmpty()) {
         boolean var3 = !var1.isEmpty();
         World var4 = var0.getWorld();
         Iterator var5 = var2.iterator();

         while(true) {
            ai.idealistic.vacan.abstraction.f.c var6;
            Location var7;
            double var8;
            double var10;
            double var12;
            do {
               do {
                  do {
                     do {
                        if (!var5.hasNext()) {
                           return;
                        }

                        var6 = (ai.idealistic.vacan.abstraction.f.c)var5.next();
                     } while(!var6.bV().equals(var4));

                     var7 = var6.bO();
                     var8 = ai.idealistic.vacan.utils.b.a.i(var7.getX(), (double)var0.getX());
                     var10 = var7.getY() - (double)var0.getY();
                     var12 = ai.idealistic.vacan.utils.b.a.i(var7.getZ(), (double)var0.getZ());
                  } while(a(var6, var8, var10, var12));
               } while(!var3);
            } while(!(Math.sqrt(var8 + var10 * var10 + var12) <= 16.0D));

            Iterator var14 = var1.iterator();

            while(var14.hasNext()) {
               Block var15 = (Block)var14.next();
               var8 = ai.idealistic.vacan.utils.b.a.i(var7.getX(), (double)var15.getX());
               var10 = var7.getY() - (double)var0.getY();
               var12 = ai.idealistic.vacan.utils.b.a.i(var7.getZ(), (double)var15.getZ());
               if (a(var6, var8, var10, var12)) {
                  break;
               }
            }
         }
      }
   }

   private static boolean a(ai.idealistic.vacan.abstraction.f.c var0, double var1, double var3, double var5) {
      if (Math.sqrt(var1 + var5) <= 3.0D && Math.abs(var3) <= 2.0D) {
         var0.gV = System.currentTimeMillis();
         return true;
      } else {
         return false;
      }
   }
}
