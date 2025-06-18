package ai.idealistic.vacan.abstraction.g;

import ai.idealistic.vacan.utils.minecraft.world.c;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;

public class a {
   private final Object hl;

   a(Object var1) {
      this.hl = var1;
   }

   public boolean dv() {
      return this.hl != null;
   }

   public boolean dw() {
      return this.hl instanceof Material;
   }

   public boolean dx() {
      return this.hl instanceof Block;
   }

   public boolean dy() {
      return c.mp && this.hl instanceof BlockData;
   }

   public Material dz() {
      if (this.hl instanceof Block) {
         return ((Block)this.hl).getType();
      } else if (this.hl instanceof Material) {
         return (Material)this.hl;
      } else {
         return c.mp && this.hl instanceof BlockData ? ((BlockData)this.hl).getMaterial() : Material.AIR;
      }
   }

   public Material dA() {
      if (this.hl instanceof Block) {
         return ((Block)this.hl).getType();
      } else if (this.hl instanceof Material) {
         return (Material)this.hl;
      } else {
         return c.mp && this.hl instanceof BlockData ? ((BlockData)this.hl).getMaterial() : null;
      }
   }

   public boolean dB() {
      return this.hl instanceof Block ? c.h((Block)this.hl) : c.mp && this.hl instanceof BlockData && c.a((BlockData)this.hl);
   }

   public boolean G(boolean var1) {
      return this.hl instanceof Block ? c.a((Block)this.hl, var1) : (this.hl instanceof Material ? c.c((Material)this.hl) : c.mp && this.hl instanceof BlockData && c.a((BlockData)this.hl, var1));
   }

   public boolean c(Material var1) {
      if (this.hl instanceof Block) {
         Block var3 = (Block)this.hl;
         return c.g(var3) && var3.getType() == var1;
      } else {
         Material var2;
         if (this.hl instanceof Material) {
            var2 = (Material)this.hl;
         } else {
            if (!c.mp || !(this.hl instanceof BlockData)) {
               return false;
            }

            var2 = ((BlockData)this.hl).getMaterial();
         }

         return c.c(var2) && var2 == var1;
      }
   }
}
