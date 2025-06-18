package ai.idealistic.vacan.utils.minecraft.a;

import ai.idealistic.vacan.functionality.server.MultiVersion;
import ai.idealistic.vacan.utils.minecraft.entity.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.World.Environment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class d {
   private static final Map<String, Material> lM = new LinkedHashMap(2);
   private static final Map<Material, Double> lN = new LinkedHashMap(2);
   private static final double lO = 1.5D;

   public static Material au(String var0) {
      return (Material)lM.get(var0.toLowerCase());
   }

   public static Material g(String var0, String var1) {
      return Material.getMaterial(MultiVersion.c(MultiVersion.MCVersion.V1_13) ? var0.toUpperCase() : var1.toUpperCase());
   }

   public static long a(ai.idealistic.vacan.abstraction.f.c var0, ItemStack var1, Material var2) {
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13) && var2.isBlock()) {
         double var3 = (Double)lN.getOrDefault(var1.getType(), 1.0D);
         boolean var5 = true;
         if (var3 == 1.5D) {
            if (var1.getType() == Material.SHEARS) {
               if (!ai.idealistic.vacan.utils.minecraft.world.c.L(var2) && !ai.idealistic.vacan.utils.minecraft.world.c.q(var2)) {
                  if (ai.idealistic.vacan.utils.minecraft.world.c.J(var2)) {
                     var3 = 5.0D;
                  }
               } else {
                  var3 = 15.0D;
               }
            } else if (ai.idealistic.vacan.utils.minecraft.world.c.L(var2)) {
               var3 = 15.0D;
            }
         }

         if (!var5) {
            var3 = 1.0D;
         } else {
            int var6 = var1.getEnchantmentLevel(b.lK);
            if (var6 > 0) {
               var3 += Math.pow((double)var6, 2.0D) + 1.0D;
            }
         }

         ai.idealistic.vacan.abstraction.f.b var14 = var0.a(e.lE, 0L);
         if (var14 != null && var14.bB()) {
            var3 *= 0.2D * (double)var14.gf.getAmplifier() + 1.0D;
         }

         ai.idealistic.vacan.abstraction.f.b var7 = var0.a(e.lF, 0L);
         if (var7 != null && var7.bB()) {
            var3 *= Math.pow((double)var7.gf.getAmplifier(), 0.3D);
         }

         boolean var8;
         if (var0.cp()) {
            var8 = true;
         } else {
            ai.idealistic.vacan.abstraction.g.a var9 = (new ai.idealistic.vacan.abstraction.g.b(var0.getLocation())).d(0.0D, var0.cn(), 0.0D).dO();
            var8 = var9.dB() || var9.dz() == au("water");
         }

         if (var8) {
            boolean var15 = false;
            if (var1.getEnchantmentLevel(b.lJ) > 0) {
               var15 = true;
            } else {
               PlayerInventory var10 = var0.cd();
               ArrayList var11 = new ArrayList(5);
               var11.addAll(Arrays.asList(var10.getArmorContents()));
               var11.add(var10.getItemInHand());
               Iterator var12 = var11.iterator();

               while(var12.hasNext()) {
                  ItemStack var13 = (ItemStack)var12.next();
                  if (var13 != null && var13.getEnchantmentLevel(b.lJ) > 0) {
                     var15 = true;
                     break;
                  }
               }
            }

            if (!var15) {
               var3 /= 5.0D;
            }
         }

         if (!var0.bI()) {
            var3 /= 5.0D;
         }

         double var16 = var3 / (double)var2.getHardness();
         if (var5) {
            var16 /= 30.0D;
         } else {
            var16 /= 100.0D;
         }

         if (var16 > 1.0D) {
            return 0L;
         } else {
            double var17 = Math.ceil(1.0D / var16);
            return (long)ai.idealistic.vacan.utils.b.a.A(var17 * 50.0D);
         }
      } else {
         return -1L;
      }
   }

   public static Material av(String var0) {
      Material[] var1 = Material.values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Material var4 = var1[var3];
         if (var4.toString().equals(var0)) {
            return var4;
         }
      }

      return null;
   }

   public static Environment aw(String var0) {
      Environment[] var1 = Environment.values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Environment var4 = var1[var3];
         if (var0.toString().equals(var0)) {
            return var4;
         }
      }

      return null;
   }

   static {
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         lM.put("water", Material.WATER);
         lM.put("lava", Material.LAVA);
         lM.put("web", Material.COBWEB);
         lM.put("gold_axe", Material.GOLDEN_AXE);
         lM.put("wood_axe", Material.WOODEN_AXE);
         lM.put("gold_pickaxe", Material.GOLDEN_PICKAXE);
         lM.put("wood_pickaxe", Material.WOODEN_PICKAXE);
         lM.put("gold_sword", Material.GOLDEN_SWORD);
         lM.put("wood_sword", Material.WOODEN_SWORD);
         lM.put("watch", Material.CLOCK);
         lM.put("exp_bottle", Material.EXPERIENCE_BOTTLE);
         lM.put("redstone_comparator", Material.COMPARATOR);
         lM.put("cake", Material.CAKE);
         lM.put("diamond_spade", Material.DIAMOND_HOE);
         lM.put("iron_spade", Material.IRON_HOE);
         lM.put("gold_spade", Material.GOLDEN_HOE);
         lM.put("stone_spade", Material.STONE_HOE);
         lM.put("wood_spade", Material.WOODEN_HOE);
         lM.put("beetroot_block", Material.BEETROOT);
         lM.put("magma", Material.MAGMA_BLOCK);
         lM.put("firework", Material.FIREWORK_ROCKET);
         lM.put("nether_portal", Material.NETHER_PORTAL);
         lM.put("cobblestone_wall", Material.COBBLESTONE_WALL);
         lM.put("end_portal_frame", Material.END_PORTAL_FRAME);
         lM.put("iron_bars", Material.IRON_BARS);
         lM.put("enchanting_table", Material.ENCHANTING_TABLE);
         lM.put("piston_extension", Material.PISTON_HEAD);
         lM.put("piston_moving", Material.MOVING_PISTON);
         lM.put("piston", Material.PISTON);
         lM.put("sticky_piston", Material.STICKY_PISTON);
         lM.put("lily_pad", Material.LILY_PAD);
         lM.put("repeater_on", Material.REPEATER);
         lM.put("repeater_off", Material.REPEATER);
         lM.put("comparator_on", Material.COMPARATOR);
         lM.put("comparator_off", Material.COMPARATOR);
         lM.put("soil", Material.FARMLAND);
         lM.put("gold_boots", Material.GOLDEN_BOOTS);
         lM.put("grass_block", Material.GRASS_BLOCK);
         lM.put("diamond_shovel", Material.DIAMOND_SHOVEL);
         lM.put("gold_shovel", Material.GOLDEN_SHOVEL);
         lM.put("iron_shovel", Material.IRON_SHOVEL);
         lM.put("stone_shovel", Material.STONE_SHOVEL);
         lM.put("wood_shovel", Material.WOODEN_SHOVEL);
         lM.put("redstone_torch", Material.REDSTONE_TORCH);
         lM.put("daylight_detector_1", Material.DAYLIGHT_DETECTOR);
         lM.put("daylight_detector_2", Material.DAYLIGHT_DETECTOR);
         lM.put("crafting_table", Material.CRAFTING_TABLE);
         lM.put("furnace", Material.FURNACE);
         lM.put("snowball", Material.SNOWBALL);
         lM.put("fireball", Material.FIRE_CHARGE);
         lM.put("lead", Material.LEAD);
         lM.put("carrot_on_a_stick", Material.CARROT_ON_A_STICK);
      } else {
         lM.put("water", Material.getMaterial("STATIONARY_WATER"));
         lM.put("lava", Material.getMaterial("STATIONARY_LAVA"));
         lM.put("web", Material.getMaterial("WEB"));
         lM.put("gold_axe", Material.getMaterial("GOLD_AXE"));
         lM.put("wood_axe", Material.getMaterial("WOOD_AXE"));
         lM.put("gold_pickaxe", Material.getMaterial("GOLD_PICKAXE"));
         lM.put("wood_pickaxe", Material.getMaterial("WOOD_PICKAXE"));
         lM.put("gold_sword", Material.getMaterial("GOLD_SWORD"));
         lM.put("wood_sword", Material.getMaterial("WOOD_SWORD"));
         lM.put("watch", Material.getMaterial("WATCH"));
         lM.put("exp_bottle", Material.getMaterial("EXP_BOTTLE"));
         lM.put("redstone_comparator", Material.getMaterial("REDSTONE_COMPARATOR"));
         lM.put("cake", Material.getMaterial("CAKE_BLOCK"));
         lM.put("diamond_spade", Material.getMaterial("DIAMOND_SPADE"));
         lM.put("iron_spade", Material.getMaterial("IRON_SPADE"));
         lM.put("gold_spade", Material.getMaterial("GOLD_SPADE"));
         lM.put("stone_spade", Material.getMaterial("STONE_SPADE"));
         lM.put("wood_spade", Material.getMaterial("WOOD_SPADE"));
         lM.put("beetroot_block", Material.getMaterial("BEETROOT_BLOCK"));
         lM.put("magma", Material.getMaterial("MAGMA"));
         lM.put("firework", Material.getMaterial("FIREWORK"));
         lM.put("nether_portal", Material.getMaterial("PORTAL"));
         lM.put("cobblestone_wall", Material.getMaterial("COBBLE_WALL"));
         lM.put("end_portal_frame", Material.getMaterial("ENDER_PORTAL_FRAME"));
         lM.put("iron_bars", Material.getMaterial("IRON_FENCE"));
         lM.put("enchanting_table", Material.getMaterial("ENCHANTMENT_TABLE"));
         lM.put("piston_extension", Material.getMaterial("PISTON_EXTENSION"));
         lM.put("piston_moving", Material.getMaterial("PISTON_MOVING_PIECE"));
         lM.put("piston", Material.getMaterial("PISTON_BASE"));
         lM.put("sticky_piston", Material.getMaterial("PISTON_STICKY_BASE"));
         lM.put("lily_pad", Material.getMaterial("WATER_LILY"));
         lM.put("repeater_on", Material.getMaterial("DIODE_BLOCK_ON"));
         lM.put("repeater_off", Material.getMaterial("DIODE_BLOCK_OFF"));
         lM.put("comparator_on", Material.getMaterial("REDSTONE_COMPARATOR_ON"));
         lM.put("comparator_off", Material.getMaterial("REDSTONE_COMPARATOR_OFF"));
         lM.put("soil", Material.getMaterial("SOIL"));
         lM.put("gold_boots", Material.getMaterial("GOLD_BOOTS"));
         lM.put("grass_block", Material.getMaterial("GRASS"));
         lM.put("diamond_shovel", Material.getMaterial("DIAMOND_SPADE"));
         lM.put("gold_shovel", Material.getMaterial("GOLD_SPADE"));
         lM.put("iron_shovel", Material.getMaterial("IRON_SPADE"));
         lM.put("stone_shovel", Material.getMaterial("STONE_SPADE"));
         lM.put("wood_shovel", Material.getMaterial("WOOD_SPADE"));
         lM.put("redstone_torch", Material.getMaterial("REDSTONE_TORCH_ON"));
         lM.put("daylight_detector_1", Material.getMaterial("DAYLIGHT_DETECTOR"));
         lM.put("daylight_detector_2", Material.getMaterial("DAYLIGHT_DETECTOR_INVERTED"));
         lM.put("crafting_table", Material.getMaterial("WORKBENCH"));
         lM.put("furnace", Material.getMaterial("BURNING_FURNACE"));
         lM.put("snowball", Material.getMaterial("SNOW_BALL"));
         lM.put("fireball", Material.getMaterial("FIREBALL"));
         lM.put("lead", Material.getMaterial("LEASH"));
         lM.put("carrot_on_a_stick", Material.getMaterial("CARROT_STICK"));
      }

      Material[] var0 = Material.values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         Material var3 = var0[var2];
         String var4 = var3.toString();
         if (ai.idealistic.vacan.utils.minecraft.world.c.h(var4, "_SWORD")) {
            lN.put(var3, 1.5D);
         } else {
            byte var6 = -1;
            switch(var4.hashCode()) {
            case -2004951435:
               if (var4.equals("WOOD_SHOVEL")) {
                  var6 = 26;
               }
               break;
            case -2004114189:
               if (var4.equals("WOOD_SPADE")) {
                  var6 = 27;
               }
               break;
            case -1850133582:
               if (var4.equals("SHEARS")) {
                  var6 = 37;
               }
               break;
            case -1850063282:
               if (var4.equals("GOLD_PICKAXE")) {
                  var6 = 29;
               }
               break;
            case -1474660721:
               if (var4.equals("GOLD_AXE")) {
                  var6 = 31;
               }
               break;
            case -1474654273:
               if (var4.equals("GOLD_HOE")) {
                  var6 = 33;
               }
               break;
            case -1376059913:
               if (var4.equals("GOLDEN_PICKAXE")) {
                  var6 = 28;
               }
               break;
            case -1092987765:
               if (var4.equals("STONE_SPADE")) {
                  var6 = 13;
               }
               break;
            case -955115213:
               if (var4.equals("STONE_PICKAXE")) {
                  var6 = 9;
               }
               break;
            case -541889864:
               if (var4.equals("GOLDEN_AXE")) {
                  var6 = 30;
               }
               break;
            case -541883416:
               if (var4.equals("GOLDEN_HOE")) {
                  var6 = 32;
               }
               break;
            case -487815164:
               if (var4.equals("WOODEN_PICKAXE")) {
                  var6 = 19;
               }
               break;
            case -374280293:
               if (var4.equals("WOOD_PICKAXE")) {
                  var6 = 20;
               }
               break;
            case -262974918:
               if (var4.equals("DIAMOND_SPADE")) {
                  var6 = 4;
               }
               break;
            case -170122909:
               if (var4.equals("DIAMOND_AXE")) {
                  var6 = 1;
               }
               break;
            case -170116461:
               if (var4.equals("DIAMOND_HOE")) {
                  var6 = 2;
               }
               break;
            case -95218994:
               if (var4.equals("IRON_SPADE")) {
                  var6 = 18;
               }
               break;
            case 70353908:
               if (var4.equals("STONE_AXE")) {
                  var6 = 10;
               }
               break;
            case 70360356:
               if (var4.equals("STONE_HOE")) {
                  var6 = 11;
               }
               break;
            case 122966710:
               if (var4.equals("IRON_PICKAXE")) {
                  var6 = 14;
               }
               break;
            case 206638182:
               if (var4.equals("GOLD_SPADE")) {
                  var6 = 36;
               }
               break;
            case 346690796:
               if (var4.equals("WOODEN_SHOVEL")) {
                  var6 = 25;
               }
               break;
            case 430758414:
               if (var4.equals("DIAMOND_SHOVEL")) {
                  var6 = 3;
               }
               break;
            case 470163933:
               if (var4.equals("STONE_SHOVEL")) {
                  var6 = 12;
               }
               break;
            case 473626359:
               if (var4.equals("IRON_AXE")) {
                  var6 = 15;
               }
               break;
            case 473632807:
               if (var4.equals("IRON_HOE")) {
                  var6 = 16;
               }
               break;
            case 726388316:
               if (var4.equals("WOOD_AXE")) {
                  var6 = 22;
               }
               break;
            case 726394764:
               if (var4.equals("WOOD_HOE")) {
                  var6 = 24;
               }
               break;
            case 872992337:
               if (var4.equals("NETHERITE_AXE")) {
                  var6 = 6;
               }
               break;
            case 872998785:
               if (var4.equals("NETHERITE_HOE")) {
                  var6 = 7;
               }
               break;
            case 1263725840:
               if (var4.equals("NETHERITE_PICKAXE")) {
                  var6 = 5;
               }
               break;
            case 1336224762:
               if (var4.equals("IRON_SHOVEL")) {
                  var6 = 17;
               }
               break;
            case 1542325061:
               if (var4.equals("WOODEN_AXE")) {
                  var6 = 21;
               }
               break;
            case 1542331509:
               if (var4.equals("WOODEN_HOE")) {
                  var6 = 23;
               }
               break;
            case 1788665440:
               if (var4.equals("NETHERITE_SHOVEL")) {
                  var6 = 8;
               }
               break;
            case 1842058393:
               if (var4.equals("GOLDEN_SHOVEL")) {
                  var6 = 34;
               }
               break;
            case 2103862626:
               if (var4.equals("GOLD_SHOVEL")) {
                  var6 = 35;
               }
               break;
            case 2118280994:
               if (var4.equals("DIAMOND_PICKAXE")) {
                  var6 = 0;
               }
            }

            switch(var6) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
               lN.put(var3, 8.0D);
               break;
            case 5:
            case 6:
            case 7:
            case 8:
               lN.put(var3, 9.0D);
               break;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
               lN.put(var3, 4.0D);
               break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
               lN.put(var3, 6.0D);
               break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
               lN.put(var3, 2.0D);
               break;
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
               lN.put(var3, 12.0D);
               break;
            case 37:
               lN.put(var3, 1.5D);
            }
         }
      }

   }
}
