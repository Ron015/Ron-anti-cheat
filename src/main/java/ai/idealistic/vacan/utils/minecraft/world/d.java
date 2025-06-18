package ai.idealistic.vacan.utils.minecraft.world;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Bisected.Half;
import org.bukkit.block.data.type.Slab;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.block.data.type.Slab.Type;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Step;
import org.bukkit.material.WoodenStep;

public class d {
   public static List<ai.idealistic.vacan.utils.minecraft.entity.a> j(Block var0) {
      ArrayList var1 = new ArrayList();
      double var2 = (double)var0.getX();
      double var4 = (double)var0.getY();
      double var6 = (double)var0.getZ();
      BlockData var8 = var0.getBlockData();
      if (var8 instanceof Slab) {
         Slab var9 = (Slab)var8;
         if (var9.getType() == Type.TOP) {
            var1.add(e(new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4 + 0.5D, var6, var2 + 1.0D, var4 + 1.0D, var6 + 1.0D)));
         } else {
            var1.add(e(new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4, var6, var2 + 1.0D, var4 + 0.5D, var6 + 1.0D)));
         }
      } else if (var8 instanceof Stairs) {
         Stairs var14 = (Stairs)var8;
         boolean var10 = false;
         var10 = var14.getHalf() == Half.TOP;
         BlockFace var11 = var14.getFacing();
         ai.idealistic.vacan.utils.minecraft.entity.a var12;
         ai.idealistic.vacan.utils.minecraft.entity.a var13;
         if (!var10) {
            var12 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4, var6, var2 + 1.0D, var4 + 0.5D, var6 + 1.0D);
            switch(var11) {
            case NORTH:
               var13 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4 + 0.5D, var6 + 0.5D, var2 + 1.0D, var4 + 1.0D, var6 + 1.0D);
               break;
            case SOUTH:
               var13 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4 + 0.5D, var6, var2 + 1.0D, var4 + 1.0D, var6 + 0.5D);
               break;
            case EAST:
               var13 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4 + 0.5D, var6, var2 + 0.5D, var4 + 1.0D, var6 + 1.0D);
               break;
            case WEST:
               var13 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2 + 0.5D, var4 + 0.5D, var6, var2 + 1.0D, var4 + 1.0D, var6 + 1.0D);
               break;
            default:
               var13 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4 + 0.5D, var6, var2 + 1.0D, var4 + 1.0D, var6 + 1.0D);
            }
         } else {
            var12 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4 + 0.5D, var6, var2 + 1.0D, var4 + 1.0D, var6 + 1.0D);
            switch(var11) {
            case NORTH:
               var13 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4, var6 + 0.5D, var2 + 1.0D, var4 + 0.5D, var6 + 1.0D);
               break;
            case SOUTH:
               var13 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4, var6, var2 + 1.0D, var4 + 0.5D, var6 + 0.5D);
               break;
            case EAST:
               var13 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4, var6, var2 + 0.5D, var4 + 0.5D, var6 + 1.0D);
               break;
            case WEST:
               var13 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2 + 0.5D, var4, var6, var2 + 1.0D, var4 + 0.5D, var6 + 1.0D);
               break;
            default:
               var13 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4, var6, var2 + 1.0D, var4 + 0.5D, var6 + 1.0D);
            }
         }

         var1.add(e(var12));
         var1.add(e(var13));
      } else {
         if (aA(var0.getType().toString().toLowerCase())) {
            return null;
         }

         var1.add(e(new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4, var6, var2 + 1.0D, var4 + 1.0D, var6 + 1.0D)));
      }

      return var1;
   }

   public static List<ai.idealistic.vacan.utils.minecraft.entity.a> k(Block var0) {
      ArrayList var1 = new ArrayList();
      double var2 = (double)var0.getX();
      double var4 = (double)var0.getY();
      double var6 = (double)var0.getZ();
      MaterialData var8 = var0.getState().getData();
      if (!(var8 instanceof Step) && !(var8 instanceof WoodenStep)) {
         if (var8 instanceof org.bukkit.material.Stairs) {
            org.bukkit.material.Stairs var13 = (org.bukkit.material.Stairs)var8;
            boolean var10 = (var0.getData() & 4) != 0;
            ai.idealistic.vacan.utils.minecraft.entity.a var11;
            ai.idealistic.vacan.utils.minecraft.entity.a var12;
            if (!var10) {
               var11 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4, var6, var2 + 1.0D, var4 + 0.5D, var6 + 1.0D);
               switch(var13.getFacing()) {
               case NORTH:
                  var12 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4 + 0.5D, var6 + 0.5D, var2 + 1.0D, var4 + 1.0D, var6 + 1.0D);
                  break;
               case SOUTH:
                  var12 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4 + 0.5D, var6, var2 + 1.0D, var4 + 1.0D, var6 + 0.5D);
                  break;
               case EAST:
                  var12 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4 + 0.5D, var6, var2 + 0.5D, var4 + 1.0D, var6 + 1.0D);
                  break;
               case WEST:
                  var12 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2 + 0.5D, var4 + 0.5D, var6, var2 + 1.0D, var4 + 1.0D, var6 + 1.0D);
                  break;
               default:
                  var12 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4 + 0.5D, var6, var2 + 1.0D, var4 + 1.0D, var6 + 1.0D);
               }
            } else {
               var11 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4 + 0.5D, var6, var2 + 1.0D, var4 + 1.0D, var6 + 1.0D);
               switch(var13.getFacing()) {
               case NORTH:
                  var12 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4, var6 + 0.5D, var2 + 1.0D, var4 + 0.5D, var6 + 1.0D);
                  break;
               case SOUTH:
                  var12 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4, var6, var2 + 1.0D, var4 + 0.5D, var6 + 0.5D);
                  break;
               case EAST:
                  var12 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4, var6, var2 + 0.5D, var4 + 0.5D, var6 + 1.0D);
                  break;
               case WEST:
                  var12 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2 + 0.5D, var4, var6, var2 + 1.0D, var4 + 0.5D, var6 + 1.0D);
                  break;
               default:
                  var12 = new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4, var6, var2 + 1.0D, var4 + 0.5D, var6 + 1.0D);
               }
            }

            var1.add(e(var11));
            var1.add(e(var12));
         } else {
            if (aA(var0.getType().toString().toLowerCase())) {
               return null;
            }

            var1.add(e(new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4, var6, var2 + 1.0D, var4 + 1.0D, var6 + 1.0D)));
         }
      } else {
         byte var9 = var0.getData();
         if ((var9 & 8) != 0) {
            var1.add(e(new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4 + 0.5D, var6, var2 + 1.0D, var4 + 1.0D, var6 + 1.0D)));
         } else {
            var1.add(e(new ai.idealistic.vacan.utils.minecraft.entity.a(var2, var4, var6, var2 + 1.0D, var4 + 0.5D, var6 + 1.0D)));
         }
      }

      return var1;
   }

   public static boolean aA(String var0) {
      return var0.matches(".*(snow|step|frame|table|slab|stair|ladder|vine|waterlily|wall|carpet|fence|rod|bed|skull|pot|hopper|door|bars|piston|lily).*");
   }

   public static ai.idealistic.vacan.utils.minecraft.entity.a e(ai.idealistic.vacan.utils.minecraft.entity.a var0) {
      return var0.k(-1.0E-4D, -1.0E-4D, -1.0E-4D);
   }
}
