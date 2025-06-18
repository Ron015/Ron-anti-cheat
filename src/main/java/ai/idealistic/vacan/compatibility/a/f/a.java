package ai.idealistic.vacan.compatibility.a.f;

import ai.idealistic.vacan.abstraction.f.c;
import ai.idealistic.vacan.compatibility.Compatibility;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import ai.idealistic.vacan.utils.a.e;
import java.util.Collection;
import java.util.Iterator;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class a {
   public static final boolean hu = e.aa("org.bukkit.attribute.Attribute") && e.aa("org.bukkit.attribute.AttributeInstance") && e.aa("org.bukkit.attribute.AttributeModifier");
   public static final String hC = "GENERIC_MAX_HEALTH";
   public static final String hD = "GENERIC_FOLLOW_RANGE";
   public static final String hE = "GENERIC_LUCK";
   public static final String hF = "ZOMBIE_SPAWN_REINFORCEMENTS";
   public static final String hG = "GENERIC_GRAVITY";
   public static final String hH = "GENERIC_MAX_ABSORPTION";
   public static final String hI = "GENERIC_MOVEMENT_SPEED";
   public static final String hJ = "GENERIC_FLYING_SPEED";
   public static final String hK = "GENERIC_ATTACK_DAMAGE";
   public static final String hL = "GENERIC_ATTACK_SPEED";
   public static final String hM = "GENERIC_ATTACK_KNOCKBACK";
   public static final String hN = "GENERIC_KNOCKBACK_RESISTANCE";
   public static final String hO = "GENERIC_ARMOR";
   public static final String hP = "GENERIC_ARMOR_TOUGHNESS";
   public static final String hQ = "GENERIC_FALL_DAMAGE_MULTIPLIER";
   public static final String hR = "GENERIC_SAFE_FALL_DISTANCE";
   public static final String hS = "GENERIC_SCALE";
   public static final String hT = "GENERIC_STEP_HEIGHT";
   public static final String hU = "HORSE_JUMP_STRENGTH";
   public static final String hV = "GENERIC_JUMP_STRENGTH";
   public static final String hW = "PLAYER_BLOCK_INTERACTION_RANGE";
   public static final String hX = "PLAYER_ENTITY_INTERACTION_RANGE";
   public static final String hY = "PLAYER_BLOCK_BREAK_SPEED";

   public static double e(c var0, String var1) {
      if (hu && Compatibility.CompatibilityType.ITEM_ATTRIBUTES.isFunctional()) {
         Attribute[] var2 = Attribute.values();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            Attribute var5 = var2[var4];
            if (var5.name().equals(var1)) {
               PlayerInventory var6 = var0.cd();
               double var7 = Double.MIN_VALUE;
               ItemStack[] var9 = new ItemStack[]{var6.getHelmet(), var6.getChestplate(), var6.getLeggings(), var6.getBoots(), var6.getItemInHand(), MultiVersion.c(MultiVersion.MCVersion.V1_9) ? var6.getItemInOffHand() : null};
               int var10 = var9.length;

               for(int var11 = 0; var11 < var10; ++var11) {
                  ItemStack var12 = var9[var11];
                  if (var12 != null && var12.hasItemMeta()) {
                     ItemMeta var13 = var12.getItemMeta();
                     if (var13 != null && var13.hasAttributeModifiers()) {
                        Collection var14 = var13.getAttributeModifiers(var5);
                        AttributeModifier var16;
                        if (var14 != null && !var14.isEmpty()) {
                           for(Iterator var15 = var14.iterator(); var15.hasNext(); var7 = Math.max(var7, var16.getAmount())) {
                              var16 = (AttributeModifier)var15.next();
                           }
                        }
                     }
                  }
               }

               return var7;
            }
         }
      }

      return Double.MIN_VALUE;
   }
}
