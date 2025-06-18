package ai.idealistic.vacan.abstraction.check.implementation.c;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.compatibility.Compatibility;
import ai.idealistic.vacan.compatibility.a.b.f;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class a extends ai.idealistic.vacan.abstraction.check.e {
   private final ai.idealistic.vacan.abstraction.check.b cm = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "breaking", true);
   private final ai.idealistic.vacan.abstraction.check.b bM = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "interact", true);
   private final ai.idealistic.vacan.abstraction.check.b ef = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "place", true);
   private final ai.idealistic.vacan.abstraction.check.b eg = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "raytrace", true);

   public a(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);
   }

   private boolean a(Block var1) {
      return this.ac.bV().equals(var1.getWorld());
   }

   private double au() {
      double var1 = 7.0D;
      return Math.max(this.hackType.getCheck().a("overall_distance", var1), var1);
   }

   protected void a(boolean var1, Object var2) {
      if (var2 instanceof BlockBreakEvent) {
         this.cm.a(() -> {
            BlockBreakEvent var2x = (BlockBreakEvent)var2;
            Block var3 = var2x.getBlock();
            if (this.a(var3) && !ai.idealistic.vacan.compatibility.a.a.d.e(var3) && !f.f(var3)) {
               double var4 = ai.idealistic.vacan.abstraction.g.b.b(this.ac.bO(), var3.getLocation());
               double var6 = this.au();
               if (var4 >= var6) {
                  this.cm.c("breaking, distance: " + var4 + ", limit: " + var6 + ", block: " + ai.idealistic.vacan.utils.minecraft.world.c.i(var3));
                  if (this.cm.j()) {
                     var2x.setCancelled(true);
                  }
               }
            }

         });
      } else if (var2 instanceof PlayerInteractEvent) {
         this.bM.a(() -> {
            Block var2x = ((PlayerInteractEvent)var2).getClickedBlock();
            if (var2x != null && this.a(var2x) && !ai.idealistic.vacan.compatibility.a.a.d.e(var2x) && ai.idealistic.vacan.utils.minecraft.world.c.U(var2x.getType())) {
               double var3 = ai.idealistic.vacan.abstraction.g.b.b(this.ac.bO(), var2x.getLocation());
               double var5 = this.au();
               if (var3 >= var5) {
                  this.bM.a(var3 / var5, "interact, distance: " + var3 + ", limit: " + var5 + ", block: " + ai.idealistic.vacan.utils.minecraft.world.c.i(var2x));
               }
            }

         });
      } else if (var2 instanceof ai.idealistic.vacan.abstraction.d.a && (this.ef.i() || this.eg.i())) {
         ai.idealistic.vacan.abstraction.d.a var3 = (ai.idealistic.vacan.abstraction.d.a)var2;
         if (ai.idealistic.vacan.utils.minecraft.world.c.ab(var3.fv.getType()) && this.a(var3.fu) && !ai.idealistic.vacan.compatibility.a.a.d.e(var3.fu) && ai.idealistic.vacan.utils.minecraft.world.c.ab(var3.fu.getType()) && !ai.idealistic.vacan.utils.minecraft.world.c.j(var3.fu.getType())) {
            Location var4 = this.ac.bO().clone().add(0.0D, this.ac.cn(), 0.0D);
            double var5 = ai.idealistic.vacan.abstraction.g.b.b(var4, var3.fu.getLocation());
            double var7 = ai.idealistic.vacan.abstraction.g.b.b(var4, var3.fv.getLocation());
            if (!this.ac.bX() && ai.idealistic.vacan.utils.minecraft.world.c.ac(var3.fu.getType()) && (!MultiVersion.c(MultiVersion.MCVersion.V1_8) || var3.fu.getType() != Material.BARRIER) && this.ac.cg() == null && var5 > var7 + 0.3D) {
               this.eg.a(() -> {
                  this.eg.a(var5 / (var7 + 0.3D), "raytrace, distance: " + var5 + ", block-against-distance: " + var7 + ", block: " + ai.idealistic.vacan.utils.minecraft.world.c.i(var3.fu));
               });
            } else {
               this.ef.a(() -> {
                  double var4 = this.au();
                  if (var5 >= var4) {
                     this.ef.a(var5 / var4, "place, distance: " + var5 + ", limit: " + var4 + ", block: " + ai.idealistic.vacan.utils.minecraft.world.c.i(var3.fu));
                  }

               });
            }
         }
      }

   }

   protected boolean m() {
      return !Compatibility.CompatibilityType.MC_MMO.isFunctional() && !Compatibility.CompatibilityType.CRAFT_BOOK.isFunctional() && !ai.idealistic.vacan.compatibility.a.b.c.i(this.ac) && !ai.idealistic.vacan.compatibility.a.a.b.i(this.ac) && !ai.idealistic.vacan.compatibility.a.b.a.i(this.ac) && ai.idealistic.vacan.compatibility.a.f.a.e(this.ac, "PLAYER_BLOCK_INTERACTION_RANGE") == Double.MIN_VALUE;
   }
}
