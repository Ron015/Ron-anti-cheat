package ai.idealistic.vacan.abstraction.d;

import com.comphenix.protocol.wrappers.BlockPosition;
import lombok.Generated;
import org.bukkit.Material;

public class j {
   public final BlockPosition fC;
   private Material fD;
   public int fE;

   public j(BlockPosition var1, Material var2) {
      this.fC = var1;
      this.fD = var2;
      this.fE = 2;
   }

   public long br() {
      return (long)this.fC.getX() * 2L + (long)this.fC.getY() * ((long)this.fC.getZ() / 2L);
   }

   @Generated
   public void a(Material var1) {
      this.fD = var1;
   }

   @Generated
   public Material bs() {
      return this.fD;
   }
}
