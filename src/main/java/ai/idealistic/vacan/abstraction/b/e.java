package ai.idealistic.vacan.abstraction.b;

import ai.idealistic.vacan.abstraction.d.g;
import ai.idealistic.vacan.abstraction.d.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class e {
   private final List<j> fc;
   private final Player fd;
   private int fe;
   public boolean aU;

   public e(Player var1) {
      this.fd = var1;
      this.fc = new ai.idealistic.vacan.utils.a.a();
      this.fe = 0;
   }

   public void a(g var1) {
      if (var1.G() < 12L) {
         this.fe = 3;
      } else if (this.fe > 0) {
         if (!this.aU) {
            --this.fe;
         }
      } else {
         this.fc.removeIf((var0) -> {
            return --var0.fE == 0;
         });
      }

   }

   public List<j> bd() {
      return new ArrayList(this.fc);
   }

   public Material k(Location var1) {
      Iterator var2 = this.fc.iterator();

      j var3;
      Location var4;
      do {
         if (!var2.hasNext()) {
            Block var5 = ai.idealistic.vacan.listeners.a.a.c.a(var1);
            return var5 == null ? null : var5.getType();
         }

         var3 = (j)var2.next();
         var4 = var3.fC.toLocation(this.fd.getWorld());
      } while(!(Math.abs(var4.getX() - var1.getX()) <= 1.3D) || !(Math.abs(var4.getY() - var1.getY()) <= 1.3D) || !(Math.abs(var4.getZ() - var1.getZ()) <= 1.3D));

      return var3.bs();
   }

   public void a(j var1) {
      if (ai.idealistic.vacan.utils.minecraft.world.c.S(var1.bs())) {
         Block var2 = ai.idealistic.vacan.listeners.a.a.c.a(var1.fC.toLocation(this.fd.getWorld()));
         if (var2 == null || ai.idealistic.vacan.utils.minecraft.world.c.S(var2.getType())) {
            return;
         }

         var1.a(var2.getType());
      }

      long var6 = (long)var1.hashCode();
      Iterator var4 = this.fc.iterator();

      while(var4.hasNext()) {
         j var5 = (j)var4.next();
         if (var5.br() == var6) {
            this.fc.remove(var5);
            break;
         }
      }

      this.fc.add(var1);
      this.aU = true;
      this.fe = 3;
   }
}
