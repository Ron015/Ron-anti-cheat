package ai.idealistic.vacan.utils.minecraft.entity;

import ai.idealistic.vacan.functionality.server.MultiVersion;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

public class b {
   public static final double kL = 6.0D;
   public static final double[] kM = new double[]{0.6D, 1.8D};

   public static DamageCause as(String var0) {
      DamageCause[] var1 = DamageCause.values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         DamageCause var4 = var1[var3];
         if (var4.name().equalsIgnoreCase(var0)) {
            return var4;
         }
      }

      return null;
   }

   public static Vector h(float var0, float var1) {
      double var2 = Math.toRadians((double)var0);
      double var4 = Math.toRadians((double)var1);
      double var6 = Math.cos(var4);
      return new Vector(-var6 * Math.sin(var2), -Math.sin(var4), var6 * Math.cos(var2));
   }

   public static double a(ai.idealistic.vacan.abstraction.g.b var0, Location var1, boolean var2) {
      double var3 = var0.u(var1);
      return var0.dC().d(h(var0.dW(), var2 ? var0.dX() : 0.0F).multiply(var3)).u(var1) / var3;
   }

   public static double a(ai.idealistic.vacan.abstraction.g.b var0, ai.idealistic.vacan.abstraction.g.b var1, boolean var2) {
      double var3 = var0.c(var1);
      return var0.dC().d(h(var0.dW(), var2 ? var0.dX() : 0.0F).multiply(var3)).c(var1) / var3;
   }

   public static double[] j(Entity var0) {
      if (MultiVersion.c(MultiVersion.MCVersion.V1_14)) {
         BoundingBox var4 = var0.getBoundingBox();
         return new double[]{var4.getMaxX() - var4.getMinX(), var0.getHeight()};
      } else {
         EntityType var1 = var0.getType();
         if (var1.toString().equals("PIG_ZOMBIE")) {
            return new double[]{0.6D, 1.95D};
         } else {
            String var2 = var1.toString();
            byte var3 = -1;
            switch(var2.hashCode()) {
            case -1337905961:
               if (var2.equals("SNOWMAN")) {
                  var3 = 0;
               }
               break;
            case -875444988:
               if (var2.equals("MUSHROOM_COW")) {
                  var3 = 1;
               }
            }

            switch(var3) {
            case 0:
               return new double[]{0.7D, 1.9D};
            case 1:
               return new double[]{0.9D, 1.4D};
            default:
               switch(var1) {
               case PLAYER:
                  return kM;
               case ZOMBIE:
                  return ((Zombie)var0).isBaby() ? new double[]{0.3D, 0.975D} : new double[]{0.6D, 1.95D};
               case VILLAGER:
               case WITCH:
                  return new double[]{0.6D, 1.95D};
               case MAGMA_CUBE:
                  switch(((MagmaCube)var0).getSize()) {
                  case 2:
                     return new double[]{1.02D, 1.02D};
                  case 3:
                     return new double[]{2.04D, 2.04D};
                  default:
                     return new double[]{0.51D, 0.51D};
                  }
               case SLIME:
                  switch(((Slime)var0).getSize()) {
                  case 2:
                     return new double[]{1.02D, 1.02D};
                  case 3:
                     return new double[]{2.04D, 2.04D};
                  default:
                     return new double[]{0.51D, 0.51D};
                  }
               case CREEPER:
                  return new double[]{0.6D, 1.7D};
               case BLAZE:
                  return new double[]{0.6D, 1.8D};
               case SKELETON:
                  return new double[]{0.6D, 1.99D};
               case ENDERMAN:
                  return new double[]{0.6D, 2.9D};
               case WITHER:
                  return new double[]{0.9D, 3.5D};
               case GHAST:
                  return new double[]{4.0D, 4.0D};
               case SQUID:
                  return new double[]{0.8D, 0.8D};
               case BAT:
                  return new double[]{0.5D, 0.9D};
               case SPIDER:
                  return new double[]{1.4D, 0.9D};
               case CAVE_SPIDER:
                  return new double[]{0.7D, 0.5D};
               case HORSE:
                  return ((Horse)var0).isAdult() ? new double[]{1.3964D, 0.8D} : new double[]{0.6982D, 0.8D};
               case COW:
                  return ((Cow)var0).isAdult() ? new double[]{0.9D, 1.4D} : new double[]{0.45D, 0.7D};
               case CHICKEN:
                  return ((Chicken)var0).isAdult() ? new double[]{0.4D, 0.7D} : new double[]{0.2D, 0.35D};
               case WOLF:
                  return ((Wolf)var0).isAdult() ? new double[]{0.6D, 0.85D} : new double[]{0.3D, 0.425D};
               case PIG:
                  return ((Pig)var0).isAdult() ? new double[]{0.9D, 0.9D} : new double[]{0.45D, 0.45D};
               case SHEEP:
                  return ((Sheep)var0).isAdult() ? new double[]{0.9D, 1.3D} : new double[]{0.45D, 0.675D};
               case GIANT:
                  return new double[]{3.6D, 11.7D};
               case SILVERFISH:
                  return new double[]{0.4D, 0.3D};
               case SNOW_GOLEM:
                  return new double[]{0.7D, 1.9D};
               case IRON_GOLEM:
                  return new double[]{1.4D, 2.7D};
               case OCELOT:
                  return new double[]{0.6D, 0.7D};
               default:
                  return new double[]{0.0D, MultiVersion.c(MultiVersion.MCVersion.V1_11) ? var0.getHeight() : ai.idealistic.vacan.compatibility.b.a.b.h(var0)};
               }
            }
         }
      }
   }

   public static String k(Entity var0) {
      return var0.getType().toString().toLowerCase().replace("_", "-");
   }

   public static boolean a(ai.idealistic.vacan.abstraction.f.c var0, LivingEntity var1) {
      Location var2 = ai.idealistic.vacan.compatibility.b.a.b.f(var1);
      if (var2 == null) {
         return false;
      } else {
         Location var3 = var0.bO().clone();
         var3.setPitch(0.0F);
         ai.idealistic.vacan.abstraction.g.b var4 = new ai.idealistic.vacan.abstraction.g.b(var2.clone().add(var3.getDirection().multiply(1.0D)));
         if (ai.idealistic.vacan.utils.minecraft.world.c.ab(var4.dO().dz())) {
            return true;
         } else {
            double var5 = j(var1)[1];
            if (var5 > 1.0D) {
               for(int var7 = 1; var7 < ai.idealistic.vacan.utils.b.a.B(var5); ++var7) {
                  if (ai.idealistic.vacan.utils.minecraft.world.c.ab(var4.d(0.0D, 1.0D, 0.0D).dO().dz())) {
                     return true;
                  }
               }
            }

            return false;
         }
      }
   }

   public static boolean F(ai.idealistic.vacan.abstraction.f.c var0) {
      if (!var0.bY() && !var0.cs() && var0.cg() == null && ai.idealistic.vacan.compatibility.a.f.a.e(var0, "GENERIC_ARMOR") == Double.MIN_VALUE && ai.idealistic.vacan.compatibility.a.f.a.e(var0, "GENERIC_ATTACK_SPEED") == Double.MIN_VALUE && ai.idealistic.vacan.compatibility.a.f.a.e(var0, "GENERIC_KNOCKBACK_RESISTANCE") == Double.MIN_VALUE && ai.idealistic.vacan.compatibility.a.f.a.e(var0, "PLAYER_ENTITY_INTERACTION_RANGE") == Double.MIN_VALUE) {
         GameMode var1 = var0.cl();
         return var1 == GameMode.SURVIVAL || var1 == GameMode.ADVENTURE || var1 == GameMode.CREATIVE;
      } else {
         return false;
      }
   }

   public static boolean b(ai.idealistic.vacan.abstraction.f.c var0, LivingEntity var1) {
      return !var0.bC().getName().equals(var1.getName()) && !ai.idealistic.vacan.compatibility.a.b.b.c(var1) && !ai.idealistic.vacan.compatibility.a.a.d.c(var1);
   }
}
