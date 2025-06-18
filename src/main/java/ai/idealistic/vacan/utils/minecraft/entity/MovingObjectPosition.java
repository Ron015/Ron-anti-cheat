package ai.idealistic.vacan.utils.minecraft.entity;

import ai.idealistic.vacan.utils.minecraft.world.EnumFacing;

public class MovingObjectPosition {
   private ai.idealistic.vacan.utils.minecraft.world.b kP;
   public MovingObjectPosition.MovingObjectType kQ;
   public EnumFacing kR;
   public ai.idealistic.vacan.utils.minecraft.d.c kS;

   public MovingObjectPosition(ai.idealistic.vacan.utils.minecraft.d.c var1, EnumFacing var2, ai.idealistic.vacan.utils.minecraft.world.b var3) {
      this(MovingObjectPosition.MovingObjectType.BLOCK, var1, var2, var3);
   }

   public MovingObjectPosition(ai.idealistic.vacan.utils.minecraft.d.c var1, EnumFacing var2) {
      this(MovingObjectPosition.MovingObjectType.BLOCK, var1, var2, ai.idealistic.vacan.utils.minecraft.world.b.lY);
   }

   public MovingObjectPosition(MovingObjectPosition.MovingObjectType var1, ai.idealistic.vacan.utils.minecraft.d.c var2, EnumFacing var3, ai.idealistic.vacan.utils.minecraft.world.b var4) {
      this.kQ = var1;
      this.kP = var4;
      this.kR = var3;
      this.kS = new ai.idealistic.vacan.utils.minecraft.d.c(var2.lR, var2.lS, var2.lT);
   }

   public MovingObjectPosition(ai.idealistic.vacan.utils.minecraft.d.c var1) {
      this.kQ = MovingObjectPosition.MovingObjectType.ENTITY;
      this.kS = var1;
   }

   public ai.idealistic.vacan.utils.minecraft.world.b fE() {
      return this.kP;
   }

   public String toString() {
      return "HitResult{type=" + this.kQ + ", blockpos=" + this.kP + ", f=" + this.kR + ", pos=" + this.kS + '}';
   }

   public static enum MovingObjectType {
      MISS,
      BLOCK,
      ENTITY;

      // $FF: synthetic method
      private static MovingObjectPosition.MovingObjectType[] $values() {
         return new MovingObjectPosition.MovingObjectType[]{MISS, BLOCK, ENTITY};
      }
   }
}
