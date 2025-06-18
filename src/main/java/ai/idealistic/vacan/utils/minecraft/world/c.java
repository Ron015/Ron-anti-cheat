package ai.idealistic.vacan.utils.minecraft.world;

import ai.idealistic.vacan.functionality.server.MultiVersion;
import java.util.HashSet;
import java.util.Set;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.inventory.ItemStack;

public class c {
   public static boolean mp = ai.idealistic.vacan.utils.a.e.aa("org.bukkit.block.data.BlockData");
   public static final long mq = 250L;
   public static final Material mr = ai.idealistic.vacan.utils.minecraft.a.d.au("head");
   public static final Material ms = ai.idealistic.vacan.utils.minecraft.a.d.au("iron_bars");
   public static final Material bO = ai.idealistic.vacan.utils.minecraft.a.d.au("cake");
   public static final Material mt = ai.idealistic.vacan.utils.minecraft.a.d.au("magma");
   public static final Material mu = ai.idealistic.vacan.utils.minecraft.a.d.au("beetroot_block");
   public static final Set<Material> mv;
   public static final Set<Material> mw;
   public static final Set<Material> mx;
   public static final Set<Material> my;
   public static final Set<Material> mz;
   public static final Set<Material> mA;
   public static final Set<Material> mB;
   public static final Set<Material> mC;
   public static final Set<Material> mD;
   public static final Set<Material> mE;
   public static final Set<Material> mF;
   public static final Set<Material> mG;
   public static final Set<Material> mH;
   public static final Set<Material> mI;
   public static final Set<Material> mJ;
   public static final Set<Material> mK;
   public static final Set<Material> mL;
   public static final Set<Material> mM;
   public static final Set<Material> mN;
   public static final Set<Material> mO;
   public static final Set<Material> mP;
   public static final Set<Material> mQ;
   public static final Set<Material> mR;
   public static final Set<Material> mS;
   public static final Set<Material> mT;
   public static final Set<Material> mU;
   public static final Set<Material> mV;
   public static final Set<Material> mW;
   public static final Set<Material> mX;
   public static final Set<Material> mY;
   public static final Set<Material> mZ;
   public static final Set<Material> na;
   public static final Set<Material> nb;
   public static final Set<Material> nc;
   public static final Set<Material> nd;
   public static final Set<Material> ne;
   public static final Set<Material> nf;
   public static final Set<Material> ng;
   public static final Set<Material> nh;
   public static final Set<Material> ni;
   public static final Set<Material> nj;
   public static final Set<Material> nk;
   public static final Set<Material> nl;
   public static final Set<Material> nm;
   public static final Set<Material> nn;
   public static final Set<Material> no;
   public static final Set<Material> np;
   public static final Set<Material> nq;
   public static final Set<Material> nr;
   public static final Set<Material> ns;
   public static final Set<Material> nt;

   public static boolean h(String var0, String var1) {
      return var0.endsWith(var1) && !var0.contains("LEGACY_");
   }

   private static boolean i(String var0, String var1) {
      return var0.startsWith(var1) && !var0.contains("LEGACY_");
   }

   private static boolean j(String var0, String var1) {
      return var0.contains(var1) && !var0.contains("LEGACY_");
   }

   public static int b(World var0) {
      return MultiVersion.c(MultiVersion.MCVersion.V1_17) ? var0.getMaxHeight() : 256;
   }

   public static int c(World var0) {
      return MultiVersion.c(MultiVersion.MCVersion.V1_17) ? var0.getMinHeight() : 0;
   }

   public static boolean h(Material var0) {
      return nc.contains(var0);
   }

   public static boolean i(Material var0) {
      return nd.contains(var0);
   }

   public static boolean j(Material var0) {
      return nn.contains(var0);
   }

   public static boolean k(Material var0) {
      return nl.contains(var0);
   }

   public static boolean l(Material var0) {
      return mT.contains(var0);
   }

   public static boolean m(Material var0) {
      return mX.contains(var0);
   }

   public static boolean g(Block var0) {
      return c(var0.getType()) || var0.isLiquid();
   }

   public static boolean c(Material var0) {
      return mL.contains(var0);
   }

   public static boolean a(BlockData var0) {
      return var0 instanceof Waterlogged && ((Waterlogged)var0).isWaterlogged();
   }

   public static boolean h(Block var0) {
      return mp && a(var0.getBlockData());
   }

   public static boolean a(ai.idealistic.vacan.abstraction.g.a var0) {
      return mp && a(var0.dz().createBlockData());
   }

   public static boolean a(Object var0, boolean var1) {
      return var0 instanceof Block ? a((Block)var0, var1) : mp && var0 instanceof BlockData && a((BlockData)var0, var1);
   }

   public static boolean a(Block var0, boolean var1) {
      return (g(var0) || h(var0)) && (var1 || var0.getType() != ai.idealistic.vacan.utils.minecraft.a.d.au("lava"));
   }

   public static boolean a(BlockData var0, boolean var1) {
      return (mp && var0 instanceof Waterlogged && ((Waterlogged)var0).isWaterlogged() || c(var0.getMaterial())) && (var1 || var0.getMaterial() != ai.idealistic.vacan.utils.minecraft.a.d.au("lava"));
   }

   public static boolean n(Material var0) {
      return mQ.contains(var0);
   }

   public static boolean o(Material var0) {
      return mZ.contains(var0);
   }

   public static boolean p(Material var0) {
      return mF.contains(var0);
   }

   public static boolean q(Material var0) {
      return mU.contains(var0);
   }

   public static boolean r(Material var0) {
      return mN.contains(var0);
   }

   public static boolean s(Material var0) {
      return mO.contains(var0);
   }

   public static boolean t(Material var0) {
      return mV.contains(var0);
   }

   public static boolean u(Material var0) {
      return mK.contains(var0);
   }

   public static boolean v(Material var0) {
      return mR.contains(var0);
   }

   public static boolean w(Material var0) {
      return mS.contains(var0);
   }

   public static boolean x(Material var0) {
      return no.contains(var0);
   }

   public static boolean y(Material var0) {
      return ne.contains(var0);
   }

   public static boolean z(Material var0) {
      return mY.contains(var0);
   }

   public static boolean A(Material var0) {
      return ni.contains(var0);
   }

   public static boolean B(Material var0) {
      return mz.contains(var0);
   }

   public static boolean C(Material var0) {
      return mI.contains(var0);
   }

   public static boolean D(Material var0) {
      return mD.contains(var0);
   }

   public static boolean E(Material var0) {
      return mE.contains(var0);
   }

   public static boolean F(Material var0) {
      return mA.contains(var0);
   }

   public static boolean G(Material var0) {
      return mB.contains(var0) || mC.contains(var0);
   }

   public static boolean H(Material var0) {
      return mB.contains(var0);
   }

   public static boolean I(Material var0) {
      return mC.contains(var0);
   }

   public static boolean J(Material var0) {
      return nh.contains(var0);
   }

   public static boolean K(Material var0) {
      return mJ.contains(var0) || z(var0);
   }

   public static boolean L(Material var0) {
      return ns.contains(var0);
   }

   public static boolean M(Material var0) {
      return nt.contains(var0);
   }

   public static boolean N(Material var0) {
      return mP.contains(var0);
   }

   public static boolean O(Material var0) {
      return mM.contains(var0);
   }

   public static boolean P(Material var0) {
      return mW.contains(var0);
   }

   public static boolean Q(Material var0) {
      return na.contains(var0);
   }

   public static boolean R(Material var0) {
      return nf.contains(var0);
   }

   public static boolean S(Material var0) {
      return mv.contains(var0);
   }

   public static boolean T(Material var0) {
      return ng.contains(var0);
   }

   public static boolean U(Material var0) {
      return nk.contains(var0);
   }

   public static boolean V(Material var0) {
      return nb.contains(var0);
   }

   public static boolean W(Material var0) {
      return nq.contains(var0);
   }

   public static boolean X(Material var0) {
      return nr.contains(var0);
   }

   public static boolean Y(Material var0) {
      return nq.contains(var0) || nr.contains(var0) || MultiVersion.c(MultiVersion.MCVersion.V1_12) && mO.contains(var0);
   }

   public static boolean Z(Material var0) {
      return nm.contains(var0);
   }

   public static boolean a(Material var0, boolean var1) {
      return var1 ? mH.contains(var0) : mG.contains(var0);
   }

   public static boolean aa(Material var0) {
      return mx.contains(var0);
   }

   private static boolean a(Material var0, long var1) {
      return var1 >= 0L && var1 <= 250L || mx.contains(var0);
   }

   public static boolean a(ai.idealistic.vacan.abstraction.f.c var0, Material var1) {
      return a(var1, var0 == null ? -1L : ai.idealistic.vacan.utils.minecraft.a.d.a(var0, var0.getItemInHand(), var1));
   }

   public static boolean ab(Material var0) {
      return mw.contains(var0) || nj.contains(var0) || var0.isSolid();
   }

   public static boolean ac(Material var0) {
      return mw.contains(var0) && !nj.contains(var0);
   }

   public static boolean ad(Material var0) {
      return nj.contains(var0);
   }

   public static boolean b(ai.idealistic.vacan.abstraction.f.c var0, Material var1) {
      return np.contains(var1) || var0 != null && var0.ce();
   }

   public static boolean h(ItemStack var0) {
      return var0 != null && var0.getType() != Material.AIR;
   }

   public static String b(Environment var0) {
      return f(var0);
   }

   public static String i(Block var0) {
      return f(var0.getType().toString());
   }

   public static String b(ai.idealistic.vacan.abstraction.g.a var0) {
      return f(var0.dz().toString());
   }

   public static String ae(Material var0) {
      return f(var0);
   }

   private static String f(Object var0) {
      return var0.toString().toLowerCase().replace("_", "-");
   }

   public static boolean a(ai.idealistic.vacan.abstraction.f.c var0, ai.idealistic.vacan.abstraction.g.b var1, int var2) {
      if (MultiVersion.c(MultiVersion.MCVersion.V1_8)) {
         if (var0.bI()) {
            return var1.dO().dz() == Material.SLIME_BLOCK;
         }

         ai.idealistic.vacan.abstraction.g.b var3 = var1.dC();
         if (!ab(var3.dO().dz())) {
            int var4 = var1.dE();

            for(int var5 = var4; var5 > Math.max(c(var0.bV()), var4 - var2); --var5) {
               Material var6 = var3.d(0.0D, -1.0D, 0.0D).dO().dz();
               if (var6 == Material.SLIME_BLOCK) {
                  return true;
               }

               if (ab(var6) && var6 != Material.SNOW && !r(var6) && !p(var6) && !n(var6) && !k(var6) && !a(var6, false)) {
                  break;
               }
            }
         }
      }

      return false;
   }

   public static boolean b(ai.idealistic.vacan.abstraction.f.c var0, ai.idealistic.vacan.abstraction.g.b var1, int var2) {
      if (MultiVersion.c(MultiVersion.MCVersion.V1_12)) {
         if (var0.bI()) {
            return s(var1.dO().dz());
         }

         ai.idealistic.vacan.abstraction.g.b var3 = var1.dC();
         if (!ab(var3.dO().dz())) {
            int var4 = var1.dE();

            for(int var5 = var4; var5 > Math.max(c(var0.bV()), var4 - var2); --var5) {
               Material var6 = var3.d(0.0D, -1.0D, 0.0D).dO().dz();
               if (s(var6)) {
                  return true;
               }

               if (ab(var6)) {
                  break;
               }
            }
         }
      }

      return false;
   }

   public static boolean c(ai.idealistic.vacan.abstraction.f.c var0, ai.idealistic.vacan.abstraction.g.b var1, int var2) {
      return a(var0, var1, var2) || b(var0, var1, var2);
   }

   public static float c(ai.idealistic.vacan.abstraction.g.a var0) {
      if (X(var0.dz())) {
         return 0.8F;
      } else if (H(var0.dz())) {
         return 0.98F;
      } else {
         return I(var0.dz()) ? 0.989F : 0.6F;
      }
   }

   static {
      HashSet var0 = new HashSet();
      HashSet var1 = new HashSet();
      Material[] var2 = Material.values();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var0.add(Material.BUBBLE_COLUMN);
         var0.add(Material.KELP);
         var0.add(Material.KELP_PLANT);
         var0.add(Material.SEAGRASS);
         var0.add(Material.TALL_SEAGRASS);
         var0.add(Material.SEA_PICKLE);
         var0.add(Material.WATER);
         var0.add(Material.LAVA);
      } else {
         var0.add(Material.getMaterial("STATIONARY_WATER"));
         var0.add(Material.getMaterial("STATIONARY_LAVA"));
      }

      mL = new HashSet(var0);
      var0.clear();
      Material[] var3;
      int var4;
      int var5;
      Material var6;
      String var7;
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         if (MultiVersion.c(MultiVersion.MCVersion.V1_14)) {
            if (MultiVersion.c(MultiVersion.MCVersion.V1_17)) {
               var0.add(Material.GLOW_ITEM_FRAME);
            }

            var0.add(Material.SMITHING_TABLE);
            var0.add(Material.GRINDSTONE);
            var0.add(Material.FLETCHING_TABLE);
            var0.add(Material.STONECUTTER);
            var0.add(Material.CARTOGRAPHY_TABLE);
            var0.add(Material.BLAST_FURNACE);
            var0.add(Material.SMOKER);
            var0.add(Material.LOOM);
            var0.add(Material.BARREL);
            var0.add(Material.BELL);
         }

         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (h(var7, "_BUTTON")) {
               var0.add(var6);
            }
         }
      } else {
         var0.add(Material.getMaterial("WOOD_BUTTON"));
         var0.add(Material.STONE_BUTTON);
      }

      var0.add(Material.ITEM_FRAME);
      var0.add(Material.HOPPER);
      var0.add(Material.JUKEBOX);
      var0.add(Material.NOTE_BLOCK);
      var0.add(Material.DROPPER);
      var0.add(Material.BREWING_STAND);
      var0.add(Material.LEVER);
      var0.add(Material.ANVIL);
      var0.add(ai.idealistic.vacan.utils.minecraft.a.d.au("crafting_table"));
      var0.add(ai.idealistic.vacan.utils.minecraft.a.d.au("repeater_on"));
      var0.add(ai.idealistic.vacan.utils.minecraft.a.d.au("repeater_off"));
      var0.add(ai.idealistic.vacan.utils.minecraft.a.d.au("comparator_on"));
      var0.add(ai.idealistic.vacan.utils.minecraft.a.d.au("comparator_off"));
      var0.add(ai.idealistic.vacan.utils.minecraft.a.d.au("enchanting_table"));
      var0.add(ai.idealistic.vacan.utils.minecraft.a.d.au("end_portal_frame"));
      var0.add(ai.idealistic.vacan.utils.minecraft.a.d.au("furnace"));
      my = new HashSet(var0);
      var0.clear();
      var0.add(Material.CHEST);
      var0.add(Material.TRAPPED_CHEST);
      var0.add(Material.ENDER_CHEST);
      mz = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (var7.contains("_PLATE")) {
               var0.add(var6);
            }
         }
      } else {
         var0.add(Material.getMaterial("GOLD_PLATE"));
         var0.add(Material.getMaterial("IRON_PLATE"));
         var0.add(Material.getMaterial("STONE_PLATE"));
         var0.add(Material.getMaterial("WOOD_PLATE"));
      }

      mA = new HashSet(var0);
      var0.clear();
      var0.add(ai.idealistic.vacan.utils.minecraft.a.d.au("web"));
      ns = new HashSet(var0);
      var0.clear();
      var3 = var2;
      var4 = var2.length;

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         var7 = var6.toString();
         if (j(var7, "WIRE")) {
            var0.add(var6);
         }
      }

      ni = new HashSet(var0);
      var0.clear();
      var3 = var2;
      var4 = var2.length;

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         var7 = var6.toString();
         if (h(var7, "_ORE")) {
            var0.add(var6);
         }
      }

      nf = new HashSet(var0);
      var0.clear();
      var0.add(Material.ICE);
      var0.add(Material.PACKED_ICE);
      if (MultiVersion.c(MultiVersion.MCVersion.V1_9)) {
         var0.add(Material.FROSTED_ICE);
      }

      mB = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_9) && MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var0.add(Material.BLUE_ICE);
      }

      mC = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var0.add(Material.GLASS_PANE);
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (h(var7, "_STAINED_GLASS_PANE")) {
               var0.add(var6);
            }
         }
      } else {
         var0.add(Material.getMaterial("THIN_GLASS"));
         var0.add(Material.getMaterial("STAINED_GLASS_PANE"));
      }

      mE = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         if (MultiVersion.c(MultiVersion.MCVersion.V1_20)) {
            var0.add(Material.BAMBOO_BLOCK);
            var0.add(Material.STRIPPED_BAMBOO_BLOCK);
            var0.add(Material.BAMBOO_MOSAIC);
            var0.add(Material.BAMBOO_PLANKS);
         }

         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (h(var7, "_LOG") || h(var7, "_WOOD")) {
               var0.add(var6);
            }
         }
      } else {
         var0.add(Material.getMaterial("LOG"));
         var0.add(Material.getMaterial("LOG_2"));
      }

      ng = new HashSet(var0);
      var0.clear();
      var0.add(Material.AIR);
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (h(var7, "_AIR")) {
               var0.add(var6);
            }
         }
      }

      mv = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (h(var7, "_STAINED_GLASS")) {
               var0.add(var6);
            }
         }
      } else {
         var0.add(Material.getMaterial("STAINED_GLASS"));
      }

      var0.add(Material.GLASS);
      mD = new HashSet(var0);
      var0.clear();
      if (!MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var0.add(Material.getMaterial("STEP"));
         var0.add(Material.getMaterial("WOOD_STEP"));
      }

      var3 = var2;
      var4 = var2.length;

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         var7 = var6.toString();
         if (j(var7, "_SLAB")) {
            var0.add(var6);
         }
      }

      mF = new HashSet(var0);
      var0.clear();
      var0.add(Material.LADDER);
      var0.add(Material.VINE);
      var3 = var2;
      var4 = var2.length;

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         var7 = var6.toString();
         if (h(var7, "_VINES") || h(var7, "_VINES_PLANT")) {
            var0.add(var6);
         }
      }

      mH = new HashSet(var0);
      var0.clear();
      var0.addAll(mH);
      if (MultiVersion.c(MultiVersion.MCVersion.V1_14)) {
         if (MultiVersion.c(MultiVersion.MCVersion.V1_17)) {
            var0.add(Material.POWDER_SNOW);
         }

         var0.add(Material.SCAFFOLDING);
      }

      mG = new HashSet(var0);
      var0.clear();
      var0.add(Material.SAND);
      var0.add(Material.GRAVEL);
      if (MultiVersion.c(MultiVersion.MCVersion.V1_12)) {
         if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
            var3 = var2;
            var4 = var2.length;

            for(var5 = 0; var5 < var4; ++var5) {
               var6 = var3[var5];
               var7 = var6.toString();
               if (h(var7, "_CONCRETE_POWDER")) {
                  var0.add(var6);
               }
            }
         } else {
            var0.add(Material.getMaterial("CONCRETE_POWDER"));
         }
      }

      mJ = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var0.add(Material.TERRACOTTA);
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (h(var7, "_TERRACOTTA")) {
               var0.add(var6);
            }
         }
      } else {
         var0.add(Material.getMaterial("STAINED_CLAY"));
      }

      na = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (h(var7, "_WOOL")) {
               var0.add(var6);
            }
         }
      } else {
         var0.add(Material.getMaterial("WOOL"));
      }

      nh = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_12)) {
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (h(var7, "_CONCRETE")) {
               var0.add(var6);
            }
         }
      }

      nb = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         if (MultiVersion.c(MultiVersion.MCVersion.V1_16)) {
            if (MultiVersion.c(MultiVersion.MCVersion.V1_19)) {
               if (MultiVersion.c(MultiVersion.MCVersion.V1_20)) {
                  var0.add(Material.BAMBOO_DOOR);
               }

               var0.add(Material.MANGROVE_DOOR);
            }

            var0.add(Material.WARPED_DOOR);
            var0.add(Material.CRIMSON_DOOR);
         }

         var0.add(Material.IRON_DOOR);
         var0.add(Material.OAK_DOOR);
      } else {
         var0.add(Material.getMaterial("IRON_DOOR_BLOCK"));
         var0.add(Material.getMaterial("WOODEN_DOOR"));
      }

      if (MultiVersion.c(MultiVersion.MCVersion.V1_8)) {
         var0.add(Material.ACACIA_DOOR);
         var0.add(Material.BIRCH_DOOR);
         var0.add(Material.DARK_OAK_DOOR);
         var0.add(Material.JUNGLE_DOOR);
         var0.add(Material.SPRUCE_DOOR);
      }

      mI = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (h(var7, "_TRAPDOOR")) {
               var0.add(var6);
            }
         }
      } else {
         var0.add(Material.getMaterial("TRAP_DOOR"));
         if (MultiVersion.c(MultiVersion.MCVersion.V1_8)) {
            var0.add(Material.IRON_TRAPDOOR);
         }
      }

      mK = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (h(var7, "_CARPET")) {
               var0.add(var6);
            }
         }
      } else {
         var0.add(Material.getMaterial("CARPET"));
      }

      mN = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (h(var7, "_BED")) {
               var0.add(var6);
            }
         }
      } else {
         var0.add(Material.getMaterial("BED_BLOCK"));
      }

      mO = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (h(var7, "_BANNER")) {
               var0.add(var6);
            }
         }
      } else {
         var0.add(Material.getMaterial("STANDING_BANNER"));
         var0.add(Material.getMaterial("WALL_BANNER"));
      }

      mM = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_11)) {
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
               var0.add(Material.SHULKER_BOX);
            }

            if (h(var7, "_SHULKER_BOX")) {
               var0.add(var6);
            }
         }
      }

      mP = new HashSet(var0);
      var0.clear();
      var3 = var2;
      var4 = var2.length;

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         var7 = var6.toString();
         if (h(var7, "_STAIRS")) {
            var0.add(var6);
         }
      }

      mQ = new HashSet(var0);
      var0.clear();
      if (!MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var0.add(Material.getMaterial("FENCE"));
      }

      var3 = var2;
      var4 = var2.length;

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         var7 = var6.toString();
         if (h(var7, "_FENCE")) {
            var0.add(var6);
         }
      }

      mR = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_17)) {
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (h(var7, "CANDLE")) {
               var0.add(var6);
            }
         }
      }

      nc = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_17)) {
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (h(var7, "CANDLE_CAKE")) {
               var0.add(var6);
            }
         }
      }

      nd = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_17)) {
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (j(var7, "DRIPLEAF")) {
               var0.add(var6);
            }
         }
      }

      ne = new HashSet(var0);
      var0.clear();
      if (!MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var0.add(Material.getMaterial("FENCE_GATE"));
      }

      var3 = var2;
      var4 = var2.length;

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         var7 = var6.toString();
         if (h(var7, "_FENCE_GATE")) {
            var0.add(var6);
         }
      }

      mS = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var0.add(Material.SKELETON_SKULL);
         var0.add(Material.SKELETON_WALL_SKULL);
         var0.add(Material.WITHER_SKELETON_SKULL);
         var0.add(Material.WITHER_SKELETON_WALL_SKULL);
         var0.add(Material.CREEPER_HEAD);
         var0.add(Material.CREEPER_WALL_HEAD);
         var0.add(Material.DRAGON_HEAD);
         var0.add(Material.DRAGON_WALL_HEAD);
         var0.add(Material.PLAYER_HEAD);
         var0.add(Material.PLAYER_WALL_HEAD);
         var0.add(Material.ZOMBIE_HEAD);
         var0.add(Material.ZOMBIE_WALL_HEAD);
      } else {
         var0.add(Material.getMaterial("SKULL"));
      }

      mT = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (h(var7, "_LEAVES")) {
               var0.add(var6);
            }
         }
      } else {
         var0.add(Material.getMaterial("LEAVES"));
         var0.add(Material.getMaterial("LEAVES_2"));
      }

      mU = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (h(var7, "_SPAWN_EGG")) {
               var0.add(var6);
            }
         }
      } else {
         var0.add(Material.getMaterial("MONSTER_EGG"));
      }

      mV = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var0.add(Material.BRAIN_CORAL_FAN);
         var0.add(Material.BRAIN_CORAL);
         var0.add(Material.DEAD_BRAIN_CORAL_FAN);
         var0.add(Material.DEAD_BRAIN_CORAL);
         var0.add(Material.DEAD_BRAIN_CORAL_WALL_FAN);
         var0.add(Material.BUBBLE_CORAL_FAN);
         var0.add(Material.BUBBLE_CORAL);
         var0.add(Material.DEAD_BUBBLE_CORAL_FAN);
         var0.add(Material.DEAD_BUBBLE_CORAL);
         var0.add(Material.DEAD_BUBBLE_CORAL_WALL_FAN);
         var0.add(Material.FIRE_CORAL_FAN);
         var0.add(Material.FIRE_CORAL);
         var0.add(Material.DEAD_FIRE_CORAL_FAN);
         var0.add(Material.DEAD_FIRE_CORAL);
         var0.add(Material.DEAD_FIRE_CORAL_WALL_FAN);
         var0.add(Material.HORN_CORAL_FAN);
         var0.add(Material.HORN_CORAL);
         var0.add(Material.DEAD_HORN_CORAL_FAN);
         var0.add(Material.DEAD_HORN_CORAL);
         var0.add(Material.DEAD_HORN_CORAL_WALL_FAN);
         var0.add(Material.TUBE_CORAL_FAN);
         var0.add(Material.TUBE_CORAL);
         var0.add(Material.DEAD_TUBE_CORAL_FAN);
         var0.add(Material.DEAD_TUBE_CORAL);
         var0.add(Material.DEAD_TUBE_CORAL_WALL_FAN);
      }

      mW = new HashSet(var0);
      var0.clear();
      var0.add(Material.FLOWER_POT);
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (i(var7, "POTTED_")) {
               var0.add(var6);
            }
         }
      }

      mX = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var0.add(Material.ANVIL);
         var0.add(Material.CHIPPED_ANVIL);
         var0.add(Material.DAMAGED_ANVIL);
      } else {
         var0.add(Material.ANVIL);
      }

      mY = new HashSet(var0);
      var0.clear();
      var3 = var2;
      var4 = var2.length;

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         var7 = var6.toString();
         if (h(var7, "_WALL")) {
            var0.add(var6);
         }
      }

      mZ = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_17)) {
         var0.add(Material.POWDER_SNOW);
      }

      no = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_14)) {
         var0.add(Material.SCAFFOLDING);
      }

      nn = new HashSet(var0);
      var0.clear();
      var3 = var2;
      var4 = var2.length;

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         if (y(var6) || L(var6) || x(var6) || j(var6)) {
            var0.add(var6);
         }
      }

      np = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var0.add(Material.PISTON);
         var0.add(Material.STICKY_PISTON);
      } else {
         var0.add(Material.getMaterial("PISTON_BASE"));
         var0.add(Material.getMaterial("PISTON_STICKY_BASE"));
      }

      nt = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         if (MultiVersion.c(MultiVersion.MCVersion.V1_14)) {
            if (MultiVersion.c(MultiVersion.MCVersion.V1_16)) {
               if (MultiVersion.c(MultiVersion.MCVersion.V1_17)) {
                  if (MultiVersion.c(MultiVersion.MCVersion.V1_19)) {
                     var1.add(Material.SCULK_SENSOR);
                     var1.add(Material.SCULK_SHRIEKER);
                     var1.add(Material.MUD);
                  }

                  var1.add(Material.DIRT_PATH);
                  var1.add(Material.LIGHTNING_ROD);
                  var1.add(Material.POINTED_DRIPSTONE);
                  var1.add(Material.SMALL_AMETHYST_BUD);
                  var1.add(Material.MEDIUM_AMETHYST_BUD);
                  var1.add(Material.LARGE_AMETHYST_BUD);
                  var1.add(Material.AMETHYST_CLUSTER);
                  var1.add(Material.POWDER_SNOW_CAULDRON);
                  var1.add(Material.LAVA_CAULDRON);
                  var1.add(Material.WATER_CAULDRON);
                  var1.add(Material.CAVE_VINES);
                  var1.add(Material.CAVE_VINES_PLANT);
               }

               var1.add(Material.SOUL_CAMPFIRE);
               var1.add(Material.TWISTING_VINES);
               var1.add(Material.TWISTING_VINES_PLANT);
               var1.add(Material.WEEPING_VINES);
               var1.add(Material.WEEPING_VINES_PLANT);
               var1.add(Material.CHAIN);
               var1.add(Material.SOUL_LANTERN);
            }

            var1.add(Material.BELL);
            var1.add(Material.LANTERN);
            var1.add(Material.CAMPFIRE);
            var1.add(Material.COMPOSTER);
            var1.add(Material.LECTERN);
            var1.add(Material.GRINDSTONE);
            var1.add(Material.STONECUTTER);
            var1.add(Material.BAMBOO);
         }

         var1.add(Material.PISTON_HEAD);
         var1.add(Material.COBBLESTONE_WALL);
         var1.add(Material.MOSSY_COBBLESTONE_WALL);
         var1.add(Material.IRON_BARS);
         var1.add(Material.PISTON);
         var1.add(Material.STICKY_PISTON);
         var1.add(Material.FARMLAND);
         var1.add(Material.TURTLE_EGG);
         var1.add(Material.CONDUIT);
      } else {
         if (MultiVersion.c(MultiVersion.MCVersion.V1_9)) {
            var1.add(Material.CHORUS_PLANT);
            var1.add(Material.END_CRYSTAL);
            var1.add(Material.END_ROD);
            var1.add(Material.getMaterial("GRASS_PATH"));
            var1.add(mu);
         }

         var1.add(Material.getMaterial("PISTON_EXTENSION"));
         var1.add(Material.getMaterial("COBBLE_WALL"));
         var1.add(Material.getMaterial("IRON_FENCE"));
         var1.add(Material.getMaterial("SOIL"));
         var1.add(Material.getMaterial("PISTON_BASE"));
         var1.add(Material.getMaterial("PISTON_STICKY_BASE"));
      }

      var3 = var2;
      var4 = var2.length;

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         var7 = var6.toString();
         if (h(var7, "_HANGING_SIGN")) {
            var1.add(var6);
         }
      }

      var1.add(ai.idealistic.vacan.utils.minecraft.a.d.au("web"));
      var1.add(Material.COCOA);
      var1.add(Material.DRAGON_EGG);
      var1.add(Material.HOPPER);
      var1.add(Material.FLOWER_POT);
      var1.add(Material.BREWING_STAND);
      var1.add(Material.CAULDRON);
      var1.add(Material.LADDER);
      var1.add(Material.VINE);
      var1.add(Material.SNOW);
      var1.add(Material.SNOW_BLOCK);
      var1.add(Material.CACTUS);
      var1.add(Material.SOUL_SAND);
      var1.add(ai.idealistic.vacan.utils.minecraft.a.d.au("daylight_detector_1"));
      var1.add(ai.idealistic.vacan.utils.minecraft.a.d.au("daylight_detector_2"));
      var1.add(ai.idealistic.vacan.utils.minecraft.a.d.au("repeater_on"));
      var1.add(ai.idealistic.vacan.utils.minecraft.a.d.au("repeater_off"));
      var1.add(ai.idealistic.vacan.utils.minecraft.a.d.au("comparator_on"));
      var1.add(ai.idealistic.vacan.utils.minecraft.a.d.au("comparator_off"));
      var1.add(ai.idealistic.vacan.utils.minecraft.a.d.au("enchanting_table"));
      var1.add(ai.idealistic.vacan.utils.minecraft.a.d.au("lily_pad"));
      var1.add(ai.idealistic.vacan.utils.minecraft.a.d.au("end_portal_frame"));
      var1.add(ai.idealistic.vacan.utils.minecraft.a.d.au("cake"));
      var3 = var2;
      var4 = var2.length;

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         if (w(var6) || v(var6) || n(var6) || p(var6) || u(var6) || C(var6) || E(var6) || B(var6) || F(var6) || N(var6) || q(var6) || l(var6) || P(var6) || z(var6) || r(var6) || s(var6) || m(var6) || o(var6) || h(var6) || i(var6) || b((ai.idealistic.vacan.abstraction.f.c)null, var6) || var1.contains(var6)) {
            var0.add(var6);
         }
      }

      nj = new HashSet(var0);
      var0.clear();
      var3 = var2;
      var4 = var2.length;

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         if (my.contains(var6) || w(var6) || u(var6) || B(var6) || C(var6) || N(var6) || s(var6) || z(var6)) {
            var0.add(var6);
         }
      }

      nk = new HashSet(var0);
      var0.clear();
      var1.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_14)) {
         var1.add(Material.SCAFFOLDING);
         var1.add(Material.WITHER_ROSE);
         var1.add(Material.SWEET_BERRY_BUSH);
         var1.add(Material.CORNFLOWER);
         var1.add(Material.LILY_OF_THE_VALLEY);
      } else {
         var1.add(Material.getMaterial("SIGN"));
      }

      var3 = var2;
      var4 = var2.length;

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         var7 = var6.toString();
         if (h(var7, "GRASS")) {
            var1.add(var6);
         }
      }

      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         if (MultiVersion.c(MultiVersion.MCVersion.V1_16)) {
            if (MultiVersion.c(MultiVersion.MCVersion.V1_17)) {
               if (MultiVersion.c(MultiVersion.MCVersion.V1_19)) {
                  if (MultiVersion.c(MultiVersion.MCVersion.V1_20)) {
                     var1.add(Material.PINK_PETALS);
                  }

                  var1.add(Material.SCULK_VEIN);
               }

               var1.add(Material.GLOW_LICHEN);
               var1.add(Material.SPORE_BLOSSOM);
               var1.add(Material.HANGING_ROOTS);
               var1.add(Material.CAVE_VINES);
               var1.add(Material.CAVE_VINES_PLANT);
               var1.add(Material.POWDER_SNOW);
               var1.add(Material.LIGHT);
            }

            var1.add(Material.SOUL_TORCH);
            var1.add(Material.SOUL_WALL_TORCH);
            var1.add(Material.SOUL_FIRE);
            var1.add(Material.TWISTING_VINES);
            var1.add(Material.TWISTING_VINES_PLANT);
            var1.add(Material.WEEPING_VINES);
            var1.add(Material.WEEPING_VINES_PLANT);
            var1.add(Material.WARPED_ROOTS);
            var1.add(Material.CRIMSON_ROOTS);
            var1.add(Material.WARPED_FUNGUS);
            var1.add(Material.CRIMSON_FUNGUS);
            var1.add(Material.NETHER_SPROUTS);
         }

         var1.add(Material.GRASS_BLOCK);
         var1.add(Material.REDSTONE_TORCH);
         var1.add(Material.REDSTONE_WALL_TORCH);
         var1.add(Material.WALL_TORCH);
         var1.add(Material.RAIL);
         var1.add(Material.END_PORTAL);
         var1.add(Material.NETHER_PORTAL);
         var1.add(Material.MOVING_PISTON);
         var1.add(Material.DANDELION);
         var1.add(Material.POPPY);
         var1.add(Material.TALL_GRASS);
         var1.add(Material.POTATOES);
         var1.add(Material.CARROTS);
         var1.add(Material.NETHER_WART);
         var1.add(Material.ACTIVATOR_RAIL);
         var1.add(Material.DETECTOR_RAIL);
         var1.add(Material.POWERED_RAIL);
         var1.add(Material.BEETROOT_SEEDS);
         var1.add(Material.MELON_SEEDS);
         var1.add(Material.PUMPKIN_SEEDS);
         var1.add(Material.WHEAT);
         var1.add(Material.WHEAT_SEEDS);
         var1.add(Material.BUBBLE_COLUMN);
         var1.add(Material.CAVE_AIR);
         var1.add(Material.VOID_AIR);
         var1.add(Material.KELP);
         var1.add(Material.KELP_PLANT);
         var1.add(Material.BEETROOTS);
         var1.add(Material.FERN);
         var1.add(Material.LARGE_FERN);
         var1.add(Material.SUNFLOWER);
         var1.add(Material.AZURE_BLUET);
         var1.add(Material.ATTACHED_MELON_STEM);
         var1.add(Material.ATTACHED_PUMPKIN_STEM);
         var1.add(Material.ROSE_BUSH);
         var1.add(Material.ALLIUM);
         var1.add(Material.OXEYE_DAISY);
         var1.add(Material.BLUE_ORCHID);
         var1.add(Material.LILAC);
         var1.add(Material.PEONY);
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (h(var7, "_BUTTON") || !i(var7, "POTTED_") && (h(var7, "_SAPLING") || h(var7, "_TULIP"))) {
               var1.add(var6);
            }
         }
      } else {
         var1.add(Material.getMaterial("REDSTONE_TORCH_ON"));
         var1.add(Material.getMaterial("REDSTONE_TORCH_OFF"));
         var1.add(Material.getMaterial("SEEDS"));
         var1.add(Material.getMaterial("RAILS"));
         var1.add(Material.getMaterial("ENDER_PORTAL"));
         var1.add(Material.getMaterial("PORTAL"));
         var1.add(Material.getMaterial("PISTON_MOVING_PIECE"));
         var1.add(Material.getMaterial("CROPS"));
         var1.add(Material.getMaterial("SIGN_POST"));
         var1.add(Material.getMaterial("RED_ROSE"));
         var1.add(Material.getMaterial("FLOWER"));
         var1.add(Material.getMaterial("YELLOW_FLOWER"));
         var1.add(Material.getMaterial("SUGAR_CANE_BLOCK"));
         var1.add(Material.getMaterial("SAPLING"));
         var1.add(Material.getMaterial("LONG_GRASS"));
         var1.add(Material.getMaterial("NETHER_WARTS"));
         var1.add(Material.getMaterial("DOUBLE_PLANT"));
         var1.add(Material.getMaterial("NETHER_WARTS"));
         var1.add(Material.getMaterial("WOOD_BUTTON"));
         var1.add(Material.getMaterial("GRASS"));
         var1.add(Material.STONE_BUTTON);
      }

      var3 = var2;
      var4 = var2.length;

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         var7 = var6.toString();
         if (h(var7, "_SIGN") && !j(var7, "_HANGING_") || h(var7, "_CROP")) {
            var1.add(var6);
         }
      }

      if (MultiVersion.c(MultiVersion.MCVersion.V1_8)) {
         if (MultiVersion.c(MultiVersion.MCVersion.V1_9)) {
            if (MultiVersion.c(MultiVersion.MCVersion.V1_10)) {
               var1.add(Material.STRUCTURE_VOID);
            }

            var1.add(Material.BEETROOT_SEEDS);
            var1.add(Material.END_GATEWAY);
         }

         var1.add(Material.ARMOR_STAND);
      }

      var1.add(Material.SUGAR_CANE);
      var1.add(Material.AIR);
      var1.add(Material.BROWN_MUSHROOM);
      var1.add(Material.RED_MUSHROOM);
      var1.add(Material.TORCH);
      var1.add(Material.TRIPWIRE);
      var1.add(Material.TRIPWIRE_HOOK);
      var1.add(Material.REDSTONE_WIRE);
      var1.add(Material.ACTIVATOR_RAIL);
      var1.add(Material.DETECTOR_RAIL);
      var1.add(Material.POWERED_RAIL);
      var1.add(Material.MELON_SEEDS);
      var1.add(Material.PUMPKIN_SEEDS);
      var1.add(Material.PUMPKIN_STEM);
      var1.add(Material.MELON_STEM);
      var1.add(Material.CARROT);
      var1.add(Material.FIRE);
      var1.add(Material.POTATO);
      var1.add(Material.LEVER);
      var1.add(Material.DEAD_BUSH);
      var1.add(Material.VINE);
      var3 = var2;
      var4 = var2.length;

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         if (!w(var6) && !u(var6) && !F(var6) && !c(var6) && !y(var6) && !O(var6) && !var1.contains(var6)) {
            var0.add(var6);
         }
      }

      mw = new HashSet(var0);
      var0.clear();
      var1.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_9)) {
         var1.add(Material.END_CRYSTAL);
         var1.add(Material.CHORUS_PLANT);
      }

      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         if (MultiVersion.c(MultiVersion.MCVersion.V1_14)) {
            if (MultiVersion.c(MultiVersion.MCVersion.V1_15)) {
               if (MultiVersion.c(MultiVersion.MCVersion.V1_16)) {
                  if (MultiVersion.c(MultiVersion.MCVersion.V1_17)) {
                     if (MultiVersion.c(MultiVersion.MCVersion.V1_19)) {
                        var1.add(Material.MUD);
                     }

                     var1.add(Material.GLOW_LICHEN);
                     var1.add(Material.GLOW_ITEM_FRAME);
                     var1.add(Material.AZALEA);
                     var1.add(Material.FLOWERING_AZALEA);
                     var1.add(Material.TINTED_GLASS);
                     var1.add(Material.CALCITE);
                  }

                  var1.add(Material.WARPED_WART_BLOCK);
                  var1.add(Material.NETHER_WART_BLOCK);
                  var1.add(Material.WARPED_NYLIUM);
                  var1.add(Material.CRIMSON_NYLIUM);
               }

               var1.add(Material.HONEY_BLOCK);
            }

            var1.add(Material.BAMBOO);
         }

         var1.add(Material.TURTLE_EGG);
         var1.add(Material.BROWN_MUSHROOM);
         var1.add(Material.RED_MUSHROOM);
         var1.add(Material.BROWN_MUSHROOM_BLOCK);
         var1.add(Material.RED_MUSHROOM_BLOCK);
         var1.add(Material.MUSHROOM_STEM);
         var1.add(Material.CUT_SANDSTONE);
         var1.add(Material.CUT_RED_SANDSTONE);
         var1.add(Material.PODZOL);
         var3 = var2;
         var4 = var2.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            var7 = var6.toString();
            if (i(var7, "INFESTED_")) {
               var1.add(var6);
            }
         }
      } else {
         if (MultiVersion.c(MultiVersion.MCVersion.V1_8)) {
            if (MultiVersion.c(MultiVersion.MCVersion.V1_9)) {
               if (MultiVersion.c(MultiVersion.MCVersion.V1_10)) {
                  var1.add(mt);
               }

               var1.add(Material.END_ROD);
               var1.add(mu);
            }

            var1.add(Material.SLIME_BLOCK);
            var1.add(Material.RED_SANDSTONE);
            var1.add(Material.RED_SANDSTONE_STAIRS);
         }

         var1.add(Material.getMaterial("HUGE_MUSHROOM_1"));
         var1.add(Material.getMaterial("HUGE_MUSHROOM_2"));
      }

      var1.add(Material.ITEM_FRAME);
      var1.add(Material.LADDER);
      var1.add(Material.TNT);
      var1.add(Material.COCOA);
      var1.add(Material.NETHERRACK);
      var1.add(Material.GLASS);
      var1.add(Material.SANDSTONE);
      var1.add(Material.SANDSTONE_STAIRS);
      var1.add(Material.QUARTZ_BLOCK);
      var1.add(Material.QUARTZ_STAIRS);
      var1.add(Material.SNOW);
      var1.add(Material.SNOW_BLOCK);
      var1.add(Material.SOUL_SAND);
      var1.add(Material.PUMPKIN);
      var1.add(ai.idealistic.vacan.utils.minecraft.a.d.au("lily_pad"));
      var1.add(ai.idealistic.vacan.utils.minecraft.a.d.au("daylight_detector_1"));
      var1.add(ai.idealistic.vacan.utils.minecraft.a.d.au("daylight_detector_2"));
      var1.add(ai.idealistic.vacan.utils.minecraft.a.d.au("repeater_on"));
      var1.add(ai.idealistic.vacan.utils.minecraft.a.d.au("repeater_off"));
      var1.add(ai.idealistic.vacan.utils.minecraft.a.d.au("comparator_on"));
      var1.add(ai.idealistic.vacan.utils.minecraft.a.d.au("comparator_off"));
      var1.add(ai.idealistic.vacan.utils.minecraft.a.d.au("enchanting_table"));
      var3 = var2;
      var4 = var2.length;

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         if (!ab(var6) || D(var6) || E(var6) || G(var6) || P(var6) || q(var6) || l(var6) || s(var6) || r(var6) || m(var6) || c(var6) || j(var6) || x(var6) || y(var6) || h(var6) || i(var6) || var1.contains(var6)) {
            var0.add(var6);
         }
      }

      mx = new HashSet(var0);
      var0.clear();
      var1.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_9)) {
         if (MultiVersion.c(MultiVersion.MCVersion.V1_15)) {
            if (MultiVersion.c(MultiVersion.MCVersion.V1_16)) {
               if (MultiVersion.c(MultiVersion.MCVersion.V1_17)) {
                  var1.add(Material.LIGHTNING_ROD);
               }

               var1.add(Material.CHAIN);
            }

            var1.add(Material.HONEY_BLOCK);
         }

         var1.add(Material.CHORUS_PLANT);
         var1.add(Material.END_ROD);
      }

      var1.add(Material.CACTUS);
      var1.add(Material.COCOA);
      var1.add(Material.DRAGON_EGG);
      var1.add(ms);
      var1.add(bO);
      var1.add(mr);
      var3 = var2;
      var4 = var2.length;

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         if (E(var6) || C(var6) || u(var6) || B(var6) || v(var6) || w(var6) || o(var6) || m(var6) || z(var6) || var1.contains(var6)) {
            var0.add(var6);
         }
      }

      nl = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_14)) {
         var0.add(Material.SWEET_BERRY_BUSH);
      }

      nm = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_15)) {
         var0.add(Material.HONEY_BLOCK);
      }

      nq = new HashSet(var0);
      var0.clear();
      if (MultiVersion.c(MultiVersion.MCVersion.V1_8)) {
         var0.add(Material.SLIME_BLOCK);
      }

      nr = new HashSet(var0);
      var0.clear();
      var1.clear();
   }
}
