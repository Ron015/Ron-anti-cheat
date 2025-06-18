package ai.idealistic.vacan.compatibility;

import ai.idealistic.vacan.Register;
import ai.idealistic.vacan.abstraction.a.a;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.compatibility.a.a.c;
import ai.idealistic.vacan.compatibility.a.a.e;
import ai.idealistic.vacan.compatibility.a.a.f;
import ai.idealistic.vacan.compatibility.a.a.a.b;
import ai.idealistic.vacan.compatibility.a.b.d;
import ai.idealistic.vacan.compatibility.a.b.g;
import ai.idealistic.vacan.compatibility.a.b.h;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Generated;
import org.bukkit.configuration.file.YamlConfiguration;

public class Compatibility {
   private static final String hr = "compatibility";
   private static final String hs = a.g("compatibility");
   private static File d;
   private static final Map<String, Boolean> eD;

   public File ax() {
      return d;
   }

   private static void refresh(boolean var0) {
      Compatibility.CompatibilityType[] var1 = Compatibility.CompatibilityType.values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Compatibility.CompatibilityType var4 = var1[var3];
         var4.refresh(var0);
      }

      Compatibility.CompatibilityType.MC_MMO.setFunctional();
      Compatibility.CompatibilityType.TREE_FELLER.setFunctional(new String[]{Compatibility.CompatibilityType.TREE_FELLER.toString()}, new Compatibility.CompatibilityType[]{Compatibility.CompatibilityType.MC_MMO}, (Runnable)null, (Runnable)null);
      Compatibility.CompatibilityType.CRAFT_BOOK.setFunctional(ai.idealistic.vacan.compatibility.a.e.a::er, (Runnable)null);
      Compatibility.CompatibilityType.CRACK_SHOT.setFunctional(() -> {
         Register.enable(new ai.idealistic.vacan.compatibility.a.a.a.a());
      }, (Runnable)null);
      Compatibility.CompatibilityType.CRACK_SHOT_PLUS.setFunctional(() -> {
         Register.enable(new b());
      }, (Runnable)null);
      Compatibility.CompatibilityType.REAL_DUAL_WIELD.setFunctional(() -> {
         Register.enable(new ai.idealistic.vacan.compatibility.a.c.a());
      }, (Runnable)null);
      Compatibility.CompatibilityType.MAGIC_SPELLS.setFunctional(() -> {
         Register.enable(new e());
      }, (Runnable)null);
      Compatibility.CompatibilityType.ADVANCED_ABILITIES.setFunctional(() -> {
         Register.enable(new ai.idealistic.vacan.compatibility.a.a.a());
      }, (Runnable)null);
      Compatibility.CompatibilityType.OLD_COMBAT_MECHANICS.setFunctional();
      Compatibility.CompatibilityType.VEIN_MINER.setFunctional(g::eq, (Runnable)null);
      Compatibility.CompatibilityType.PROJECT_KORRA.setFunctional(() -> {
         Register.enable(new ai.idealistic.vacan.compatibility.a.a.g());
      }, (Runnable)null);
      Compatibility.CompatibilityType.GRAPPLING_HOOK.setFunctional(() -> {
         Register.enable(new c());
      }, (Runnable)null);
      Compatibility.CompatibilityType.MYTHIC_MOBS.setFunctional(ai.idealistic.vacan.compatibility.a.b.b::eq, (Runnable)null);
      Compatibility.CompatibilityType.CUSTOM_ENCHANTS_PLUS.setFunctional();
      Compatibility.CompatibilityType.ECO_ENCHANTS.setFunctional(ai.idealistic.vacan.utils.a.e.aa("com.willfp.ecoenchants.enchants.EcoEnchant"));
      Compatibility.CompatibilityType.ADVANCED_ENCHANTMENTS.setFunctional(new String[]{Compatibility.CompatibilityType.ADVANCED_ENCHANTMENTS.toString()}, (Compatibility.CompatibilityType[])null, (Runnable)null, (Runnable)null);
      Compatibility.CompatibilityType.VEHICLES.setFunctional(() -> {
         Register.enable(new ai.idealistic.vacan.compatibility.a.e.b());
      }, (Runnable)null);
      Compatibility.CompatibilityType.MINE_TINKER.setFunctional(() -> {
         Register.enable(new f());
      }, (Runnable)null);
      if (MultiVersion.c(MultiVersion.MCVersion.V1_9)) {
         Compatibility.CompatibilityType.ITEM_ATTRIBUTES.setFunctional(new String[]{""}, new Compatibility.CompatibilityType[]{Compatibility.CompatibilityType.MINE_TINKER, Compatibility.CompatibilityType.MYTHIC_MOBS, Compatibility.CompatibilityType.PROJECT_KORRA}, (Runnable)null, (Runnable)null);
      }

      Compatibility.CompatibilityType.WILD_TOOLS.setFunctional(() -> {
         Register.enable(new h());
      }, (Runnable)null);
      Compatibility.CompatibilityType.FLOODGATE.setFunctional(new String[]{"%" + Compatibility.CompatibilityType.FLOODGATE, "%geyser"}, (Compatibility.CompatibilityType[])null, ai.idealistic.vacan.compatibility.b.b::eq, (Runnable)null);
      Compatibility.CompatibilityType.PROTOCOL_SUPPORT.setFunctional(new String[]{"protocolsupport.api.Connection+", "protocolsupport.api.ProtocolSupportAPI+", Compatibility.CompatibilityType.PROTOCOL_SUPPORT + "+"}, (Compatibility.CompatibilityType[])null, (Runnable)null, (Runnable)null);
      Compatibility.CompatibilityType.PROTOCOL_LIB.setFunctional(ai.idealistic.vacan.compatibility.b.a.b::run, ai.idealistic.vacan.compatibility.b.a.b::ev);
      Compatibility.CompatibilityType.RAMPEN_DRILLS.setFunctional(() -> {
         Register.enable(new d());
      }, (Runnable)null);
      Compatibility.CompatibilityType.MINE_BOMB.setFunctional(ai.idealistic.vacan.compatibility.a.b.a::eq, (Runnable)null);
      Compatibility.CompatibilityType.PRINTER_MODE.setFunctional();
      Compatibility.CompatibilityType.SUPER_PICKAXE.setFunctional(new String[]{Compatibility.CompatibilityType.SUPER_PICKAXE.toString(), Compatibility.CompatibilityType.SUPER_PICKAXE + "Reloaded"}, (Compatibility.CompatibilityType[])null, (Runnable)null, (Runnable)null);
      Compatibility.CompatibilityType.AURELIUM_SKILLS.setFunctional(() -> {
         Register.enable(new ai.idealistic.vacan.compatibility.a.a.b());
      }, (Runnable)null);
      Compatibility.CompatibilityType.ITEMS_ADDER.setFunctional();
   }

   private static boolean a(String var0, boolean var1) {
      Boolean var2 = (Boolean)eD.get(var0);
      if (var2 != null) {
         return var2;
      } else {
         if (!d.exists()) {
            if (!var1) {
               return false;
            }

            ay();
         }

         boolean var3 = YamlConfiguration.loadConfiguration(d).getBoolean(var0);
         eD.put(var0, var3);
         return var3;
      }
   }

   public void dY() {
      eD.clear();
   }

   public void dZ() {
      refresh(false);
   }

   public static void ay() {
      d = new File(hs);
      eD.clear();
      refresh(true);
   }

   public List<Compatibility.CompatibilityType> ea() {
      Compatibility.CompatibilityType[] var1 = Compatibility.CompatibilityType.values();
      ArrayList var2 = new ArrayList(var1.length);
      Compatibility.CompatibilityType[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Compatibility.CompatibilityType var6 = var3[var5];
         if (var6.isFunctional()) {
            var2.add(var6);
         }
      }

      return var2;
   }

   public List<Compatibility.CompatibilityType> eb() {
      Compatibility.CompatibilityType[] var1 = Compatibility.CompatibilityType.values();
      ArrayList var2 = new ArrayList(var1.length);
      Compatibility.CompatibilityType[] var3 = Compatibility.CompatibilityType.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Compatibility.CompatibilityType var6 = var3[var5];
         if (var6.isEnabled()) {
            var2.add(var6);
         }
      }

      return var2;
   }

   public void a(ai.idealistic.vacan.abstraction.f.c var1, Compatibility.CompatibilityType var2, CheckEnums.HackType[] var3, int var4) {
      CheckEnums.HackType[] var5 = var3;
      int var6 = var3.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         CheckEnums.HackType var8 = var5[var7];
         var1.a(var8).a(var2.toString(), (String)null, var4);
      }

   }

   public void a(ai.idealistic.vacan.abstraction.f.c var1, Compatibility.CompatibilityType var2, CheckEnums.HackType var3, int var4) {
      var1.a(var3).a(var2.toString(), (String)null, var4);
   }

   public void a(ai.idealistic.vacan.abstraction.f.c var1, Compatibility.CompatibilityType var2, CheckEnums.HackCategoryType[] var3, int var4) {
      CheckEnums.HackType[] var5 = CheckEnums.HackType.values();
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         CheckEnums.HackType var8 = var5[var7];
         CheckEnums.HackCategoryType[] var9 = var3;
         int var10 = var3.length;

         for(int var11 = 0; var11 < var10; ++var11) {
            CheckEnums.HackCategoryType var12 = var9[var11];
            if (var8.category == var12) {
               var1.a(var8).a(var2.toString(), (String)null, var4);
               break;
            }
         }
      }

   }

   public void a(ai.idealistic.vacan.abstraction.f.c var1, Compatibility.CompatibilityType var2, CheckEnums.HackCategoryType var3, int var4) {
      CheckEnums.HackType[] var5 = CheckEnums.HackType.values();
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         CheckEnums.HackType var8 = var5[var7];
         if (var8.category == var3) {
            var1.a(var8).a(var2.toString(), (String)null, var4);
         }
      }

   }

   static {
      d = new File(hs);
      eD = new LinkedHashMap();
   }

   public static enum CompatibilityType {
      ADVANCED_ABILITIES("AdvancedAbilities"),
      CRACK_SHOT("CrackShot"),
      CRACK_SHOT_PLUS("CrackShotPlus"),
      CRAFT_BOOK("CraftBook"),
      MAGIC_SPELLS("MagicSpells"),
      PROTOCOL_LIB("ProtocolLib"),
      MC_MMO("mcMMO"),
      PROTOCOL_SUPPORT("ProtocolSupport"),
      TREE_FELLER("TreeFeller"),
      VEIN_MINER("VeinMiner"),
      GRAPPLING_HOOK("GrapplingHook"),
      MINE_BOMB("MineBomb"),
      SUPER_PICKAXE("SuperPickaxe"),
      REAL_DUAL_WIELD("RealDualWield"),
      MYTHIC_MOBS("MythicMobs"),
      ITEM_ATTRIBUTES("ItemAttributes"),
      PRINTER_MODE("PrinterMode"),
      VEHICLES("Vehicles"),
      MINE_TINKER("MineTinker"),
      WILD_TOOLS("WildTools"),
      AURELIUM_SKILLS("AureliumSkills"),
      CUSTOM_ENCHANTS_PLUS("CustomEncahntsPlus"),
      ECO_ENCHANTS("EcoEnchants"),
      ITEMS_ADDER("ItemsAdder"),
      RAMPEN_DRILLS("RampenDrills"),
      OLD_COMBAT_MECHANICS("OldCombatMechanics"),
      PROJECT_KORRA("ProjectKorra"),
      FLOODGATE("Floodgate"),
      ADVANCED_ENCHANTMENTS("AdvancedEnchantments");

      private boolean enabled;
      private boolean forced;
      private boolean functional;
      private boolean elseRunnable;
      private final String name;

      private CompatibilityType(String var3) {
         this.name = var3;
         this.enabled = false;
         this.forced = false;
         this.functional = false;
         this.elseRunnable = false;
      }

      public String toString() {
         return this.name;
      }

      public void refresh(boolean var1) {
         boolean var2;
         boolean var3;
         String var4;
         switch(this.ordinal()) {
         case 7:
         case 27:
            var2 = true;
            var3 = false;
            var4 = this.toString().toLowerCase();
            break;
         default:
            var2 = false;
            var3 = false;
            var4 = null;
         }

         if (var2) {
            this.enabled = true;
            this.forced = false;
            this.functional = var3 ? ai.idealistic.vacan.utils.minecraft.c.b.ay(var4) : ai.idealistic.vacan.utils.minecraft.c.b.h(var4);
         } else {
            Compatibility.d = new File(Compatibility.hs);
            String var5 = this.toString();
            if (var1) {
               ai.idealistic.vacan.utils.minecraft.c.a.a((File)Compatibility.d, var5 + ".enabled", (Object)(!this.equals(WILD_TOOLS)));
               ai.idealistic.vacan.utils.minecraft.c.a.a((File)Compatibility.d, var5 + ".force", (Object)false);
            }

            this.enabled = Compatibility.a(var5 + ".enabled", var1);
            this.forced = Compatibility.a(var5 + ".force", var1);
         }

      }

      public boolean isFunctional() {
         return this.enabled && this.functional;
      }

      public void setFunctional() {
         this.setFunctional(new String[]{this.toString()}, (Compatibility.CompatibilityType[])null, (Runnable)null, (Runnable)null);
      }

      public void setFunctional(Runnable var1, Runnable var2) {
         this.setFunctional(new String[]{this.toString()}, (Compatibility.CompatibilityType[])null, var1, var2);
      }

      public void setFunctional(String[] var1, Compatibility.CompatibilityType[] var2, Runnable var3, Runnable var4) {
         if (this.isEnabled()) {
            if (this.functional) {
               return;
            }

            boolean var5 = this.isForced();
            int var7;
            if (!var5 && var1 != null) {
               int var6 = 0;
               var7 = 0;
               String[] var8 = var1;
               int var9 = var1.length;

               for(int var10 = 0; var10 < var9; ++var10) {
                  String var11 = var8[var10];
                  if (var11.isEmpty()) {
                     var5 = true;
                     break;
                  }

                  boolean var12 = var11.endsWith("+");
                  if (var12) {
                     ++var7;
                     var11 = var11.substring(0, var11.length() - 1);
                  }

                  if (var11.contains(".")) {
                     if (!ai.idealistic.vacan.utils.a.e.aa(var11)) {
                        continue;
                     }
                  } else if (var11.startsWith("%")) {
                     if (!ai.idealistic.vacan.utils.minecraft.c.b.ay(var11.substring(1))) {
                        continue;
                     }
                  } else if (!ai.idealistic.vacan.utils.minecraft.c.b.h(var11)) {
                     continue;
                  }

                  if (!var12) {
                     var5 = true;
                     break;
                  }

                  ++var6;
               }

               if (!var5) {
                  var5 = var7 > 0 && var6 == var7;
               }
            }

            if (!var5 && var2 != null) {
               Compatibility.CompatibilityType[] var14 = var2;
               var7 = var2.length;

               for(int var15 = 0; var15 < var7; ++var15) {
                  Compatibility.CompatibilityType var16 = var14[var15];
                  if (var16.isFunctional()) {
                     var5 = true;
                     break;
                  }
               }
            }

            if (var5) {
               this.elseRunnable = false;
               if (var3 != null) {
                  try {
                     var3.run();
                     this.functional = true;
                  } catch (Exception var13) {
                     this.functional = false;
                     ai.idealistic.vacan.functionality.c.a.M("Compatibility '" + this.toString() + "' failed to load.");
                  }
               } else {
                  this.functional = true;
               }
            } else {
               this.functional = false;
               if (!this.elseRunnable && var4 != null) {
                  this.elseRunnable = true;
                  var4.run();
               }
            }
         } else if (!this.elseRunnable && var4 != null) {
            this.elseRunnable = true;
            var4.run();
         }

      }

      @Generated
      public void setEnabled(boolean var1) {
         this.enabled = var1;
      }

      @Generated
      public void setForced(boolean var1) {
         this.forced = var1;
      }

      @Generated
      public void setFunctional(boolean var1) {
         this.functional = var1;
      }

      @Generated
      public void setElseRunnable(boolean var1) {
         this.elseRunnable = var1;
      }

      @Generated
      public boolean isEnabled() {
         return this.enabled;
      }

      @Generated
      public boolean isForced() {
         return this.forced;
      }

      @Generated
      public boolean isElseRunnable() {
         return this.elseRunnable;
      }

      // $FF: synthetic method
      private static Compatibility.CompatibilityType[] $values() {
         return new Compatibility.CompatibilityType[]{ADVANCED_ABILITIES, CRACK_SHOT, CRACK_SHOT_PLUS, CRAFT_BOOK, MAGIC_SPELLS, PROTOCOL_LIB, MC_MMO, PROTOCOL_SUPPORT, TREE_FELLER, VEIN_MINER, GRAPPLING_HOOK, MINE_BOMB, SUPER_PICKAXE, REAL_DUAL_WIELD, MYTHIC_MOBS, ITEM_ATTRIBUTES, PRINTER_MODE, VEHICLES, MINE_TINKER, WILD_TOOLS, AURELIUM_SKILLS, CUSTOM_ENCHANTS_PLUS, ECO_ENCHANTS, ITEMS_ADDER, RAMPEN_DRILLS, OLD_COMBAT_MECHANICS, PROJECT_KORRA, FLOODGATE, ADVANCED_ENCHANTMENTS};
      }
   }
}
