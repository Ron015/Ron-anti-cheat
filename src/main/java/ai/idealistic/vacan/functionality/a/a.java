package ai.idealistic.vacan.functionality.a;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.abstraction.f.c;
import ai.idealistic.vacan.api.Permission;
import ai.idealistic.vacan.functionality.c.d;
import ai.idealistic.vacan.functionality.connection.e;
import ai.idealistic.vacan.utils.a.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class a implements CommandExecutor {
   public static final int ic = 4096;
   public static final String id = "Click to receive plugin support.";

   private static void a(CommandSender var0, ChatColor var1, String var2, String var3) {
      ai.idealistic.vacan.functionality.c.a.b.a(var0, var1 + var2, var3, var2);
   }

   public static boolean a(CommandSender var0, boolean var1, boolean var2) {
      if (var1 && !ai.idealistic.vacan.functionality.server.b.g((Player)var0)) {
         var0.sendMessage(ai.idealistic.vacan.functionality.server.a.jb.m("unknown_command"));
         return false;
      } else {
         var0.sendMessage("");
         String var3 = "§2Vacan AntiCheat";
         String var4 = "Click to view our Patreon offer/s.";
         var3 = var3 + "\n§8[ §7Checks Available§8: " + (e.j(Check.DataType.JAVA) ? "§a" : "§c") + Check.DataType.JAVA + " §8/ " + (e.j(Check.DataType.BEDROCK) ? "§a" : "§c") + Check.DataType.BEDROCK + " §8]";
         ai.idealistic.vacan.functionality.c.a.b.b(var0, var3, var4, "https://www.patreon.com/VacanAntiCheat");
         if (var2) {
            ai.idealistic.vacan.functionality.c.a.b.b(var0, "§8§l<> §7Required command argument", var4, "https://www.patreon.com/VacanAntiCheat");
            ai.idealistic.vacan.functionality.c.a.b.b(var0, "§8§l[] §7Optional command argument", var4, "https://www.patreon.com/VacanAntiCheat");
         }

         return true;
      }
   }

   public static void d(CommandSender var0, String var1) {
      boolean var2 = var0 instanceof Player;
      c var3 = var2 ? ai.idealistic.vacan.functionality.server.c.i((Player)var0) : null;
      var2 &= var3 != null;
      boolean var4 = !var2 || ai.idealistic.vacan.functionality.server.b.a(var3.bC(), Permission.INFO);
      boolean var5 = !var2 || ai.idealistic.vacan.functionality.server.b.a(var3.bC(), Permission.MANAGE);
      byte var7 = -1;
      switch(var1.hashCode()) {
      case -2016287450:
         if (var1.equals("moderation")) {
            var7 = 1;
         }
         break;
      case -930859336:
         if (var1.equals("conditions")) {
            var7 = 2;
         }
         break;
      case 1544803905:
         if (var1.equals("default")) {
            var7 = 0;
         }
      }

      switch(var7) {
      case 0:
         if (a(var0, var2, !var2)) {
            if (var2) {
               if (var5) {
                  ai.idealistic.vacan.functionality.c.a.b.a(var0, "§cPanic Mode §7(Click)", "Click this command to toggle silent mode and disable punishments for all checks.", "/vacan panic");
               }

               if (ai.idealistic.vacan.functionality.server.b.a(var3.bC(), Permission.RELOAD)) {
                  ai.idealistic.vacan.functionality.c.a.b.a(var0, "§cReload Plugin §7(Click)", "Click this command to reload the plugin's cache.", "/vacan reload");
               }

               if (var4) {
                  ai.idealistic.vacan.functionality.c.a.b.a(var0, "§cPlayer Info §7(Click)", "Click this command to view useful information yourself.", "/vacan info");
               }

               if (var5) {
                  ai.idealistic.vacan.functionality.c.a.b.a(var0, "§cToggle Checks §7(Click)", "Click this command to toggle a check and its detections.", "/vacan manage-checks");
                  ai.idealistic.vacan.functionality.c.a.b.a(var0, "§cToggle Preventions §7(Click)", "Click this command to toggle a check's preventions.", "/vacan manage-checks");
                  ai.idealistic.vacan.functionality.c.a.b.a(var0, "§cToggle Punishments §7(Click)", "Click this command to toggle a check's punishments.", "/vacan manage-checks");
               }

               if (ai.idealistic.vacan.functionality.server.b.a(var3.bC(), Permission.USE_BYPASS)) {
                  ai.idealistic.vacan.functionality.c.a.b.a(var0, "§cPlayer Bypass §7(Click)", "Click this command to give check bypass to a player.", "/vacan bypass *");
               }
            } else {
               ai.idealistic.vacan.functionality.c.a.b.a(var0, ChatColor.RED + "/" + "vacan" + " panic", "This command can be used to enable silent mode and disable punishments for all checks.", (String)null);
               ai.idealistic.vacan.functionality.c.a.b.a(var0, ChatColor.RED + "/" + "vacan" + " toggle <check>", "This command can be used to toggle a check and its detections.", (String)null);
               ai.idealistic.vacan.functionality.c.a.b.a(var0, ChatColor.RED + "/" + "vacan" + " toggle-prevention <check>", "This command can be used to toggle a check's preventions.", (String)null);
               ai.idealistic.vacan.functionality.c.a.b.a(var0, ChatColor.RED + "/" + "vacan" + " toggle-punishment <check>", "This command can be used to toggle a check's punishments.", (String)null);
               a(var0, ChatColor.RED, "/vacan reload", "Click this command to reload the plugin's cache.");
            }

            if (!var2 || var4 || ai.idealistic.vacan.functionality.server.b.a(var3.bC(), Permission.KICK) || ai.idealistic.vacan.functionality.server.b.a(var3.bC(), Permission.WARN) || ai.idealistic.vacan.functionality.server.b.a(var3.bC(), Permission.USE_BYPASS) || ai.idealistic.vacan.functionality.server.b.a(var3.bC(), Permission.WAVE)) {
               a(var0, ChatColor.RED, "/vacan moderation", "Click this command to view a list of moderation commands.");
            }
         }
         break;
      case 1:
         if (a(var0, var2, true)) {
            boolean var8 = false;
            if (var2 && ai.idealistic.vacan.functionality.c.c.s(var3)) {
               ai.idealistic.vacan.functionality.c.a.b.a(var0, ChatColor.RED + "/" + "vacan" + " notifications [ticks-frequency]", "This command can be used to receive chat messages whenever a player is suspected of using hack modules.", (String)null);
               ai.idealistic.vacan.functionality.c.a.b.a(var0, ChatColor.RED + "/" + "vacan" + " verbose", "This command can be used to enable all notifications to go through instead of only important ones when disabled.", (String)null);
            }

            if (var2 && var4) {
               ai.idealistic.vacan.functionality.c.a.b.a(var0, ChatColor.RED + "/" + "vacan" + " info [player]", "This command can be used to view useful information about a player.", (String)null);
            }

            if (!var2 || ai.idealistic.vacan.functionality.server.b.a(var3.bC(), Permission.USE_BYPASS)) {
               var8 = true;
               ai.idealistic.vacan.functionality.c.a.b.a(var0, ChatColor.RED + "/" + "vacan" + " bypass <player> <check> [seconds]", "This command can be used to cause a player to temporarily bypass a check and its detections.", (String)null);
            }

            if (!var2 || ai.idealistic.vacan.functionality.server.b.a(var3.bC(), Permission.WARN)) {
               var8 = true;
               ai.idealistic.vacan.functionality.c.a.b.a(var0, ChatColor.RED + "/" + "vacan" + " warn <player> <reason>", "This command can be used to individually warn a player about something important.", (String)null);
            }

            if (!var2 || ai.idealistic.vacan.functionality.server.b.a(var3.bC(), Permission.KICK)) {
               var8 = true;
               ai.idealistic.vacan.functionality.c.a.b.a(var0, ChatColor.RED + "/" + "vacan" + " kick <player> <reason>", "This command can be used to kick players from the server for a specific reason.", (String)null);
            }

            if (!var2 || ai.idealistic.vacan.functionality.server.b.a(var3.bC(), Permission.WAVE)) {
               var8 = true;
               ai.idealistic.vacan.functionality.c.a.b.a(var0, ChatColor.RED + "/" + "vacan" + " wave <add/remove/clear/run/list> [player] [command]", "This command can be used to add a player to a list with a command representing their punishment. This list can be executed manually by a player or automatically based on the plugin's configuration, and cause added players to punished all at once and in order.\n\nExample: /vacan wave add playerName ban {player} You have been banned for hacking!", (String)null);
            }

            if (!var2 || ai.idealistic.vacan.functionality.server.b.a(var3.bC(), Permission.ADMIN)) {
               var8 = true;
               ai.idealistic.vacan.functionality.c.a.b.a(var0, ChatColor.RED + "/" + "vacan" + " proxy-command <command>", "This command can be used to transfer commands to the proxy/network of servers. (Example: BungeeCord)", (String)null);
            }

            if (!var8) {
               d(var0, "default");
            }
         }
         break;
      case 2:
         if (a(var0, var2, true)) {
            if (var2 && !ai.idealistic.vacan.functionality.server.b.a(var3.bC(), Permission.CONDITION)) {
               d(var0, "default");
            } else {
               var0.sendMessage(ChatColor.RED + "/" + "vacan" + " <player> if <condition> equals <result> do <command>");
               var0.sendMessage(ChatColor.RED + "/" + "vacan" + " <player> if <condition> contains <result> do <command>");
               var0.sendMessage(ChatColor.RED + "/" + "vacan" + " <player> if <number> is-less-than <result> do <command>");
               var0.sendMessage(ChatColor.RED + "/" + "vacan" + " <player> if <number> is-greater-than <result> do <command>");
            }
         }
      }

   }

   public static int G(String var0) {
      return Integer.parseInt(var0);
   }

   public static double H(String var0) {
      return Double.parseDouble(var0);
   }

   public boolean onCommand(CommandSender var1, Command var2, String var3, String[] var4) {
      label732: {
         boolean var5 = var1 instanceof Player;
         if (var3.equalsIgnoreCase("vacan") && (var5 || var1 instanceof ConsoleCommandSender)) {
            c var6 = var5 ? ai.idealistic.vacan.functionality.server.c.i((Player)var1) : null;
            if (var4.length == 0) {
               if (var5 && ai.idealistic.vacan.listeners.a.jL && ai.idealistic.vacan.functionality.server.b.h(var6.bC()) && ai.idealistic.vacan.functionality.server.a.iZ.i("Important.enable_npc")) {
                  ai.idealistic.vacan.listeners.a.A(var6);
               }

               d(var1, "default");
            } else if (var4.length == 1) {
               if (var5 && var4[0].equalsIgnoreCase("Manage-Checks")) {
                  ai.idealistic.vacan.functionality.server.c.jl.e(var6);
               } else if (var4[0].equalsIgnoreCase("Panic")) {
                  if (var5 && !ai.idealistic.vacan.functionality.server.b.a(var6.bC(), Permission.MANAGE)) {
                     ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                     return true;
                  }

                  Check.a(!Check.a());
                  if (Check.a()) {
                     ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("panic_mode_enable"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                  } else {
                     ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("panic_mode_disable"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                  }
               } else if (var4[0].equalsIgnoreCase("Moderation")) {
                  d(var1, var4[0].toLowerCase());
               } else if (var4[0].equalsIgnoreCase("Conditions")) {
                  d(var1, var4[0].toLowerCase());
               } else if (!var4[0].equalsIgnoreCase("Reload") && !var4[0].equalsIgnoreCase("Rl")) {
                  if (var5 && var4[0].equalsIgnoreCase("Info")) {
                     if (!ai.idealistic.vacan.functionality.server.b.a(var6.bC(), Permission.INFO)) {
                        ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                        return true;
                     }

                     ai.idealistic.vacan.functionality.server.c.jm.a(var6, var1.getName());
                  } else if (var5 && var4[0].equalsIgnoreCase("Notifications")) {
                     if (!ai.idealistic.vacan.functionality.c.c.s(var6)) {
                        ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                        return true;
                     }

                     ai.idealistic.vacan.functionality.c.c.c(var6, Integer.MIN_VALUE);
                  } else if (var5 && var4[0].equalsIgnoreCase("Verbose")) {
                     if (!ai.idealistic.vacan.functionality.c.c.s(var6)) {
                        ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                        return true;
                     }

                     if (ai.idealistic.vacan.functionality.c.c.r(var6)) {
                        ai.idealistic.vacan.functionality.c.c.v(var6);
                     } else {
                        ai.idealistic.vacan.functionality.c.c.w(var6);
                     }
                  } else {
                     d(var1, "default");
                  }
               } else {
                  if (var5 && !ai.idealistic.vacan.functionality.server.b.a(var6.bC(), Permission.RELOAD)) {
                     ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                     return true;
                  }

                  ai.idealistic.vacan.functionality.server.a.a(var1);
               }
            } else {
               StringBuilder var7;
               int var8;
               String var25;
               if (var4[0].equalsIgnoreCase("Proxy-Command")) {
                  if (var5 && !ai.idealistic.vacan.functionality.server.b.a(var6.bC(), Permission.ADMIN)) {
                     ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                     return true;
                  }

                  var7 = new StringBuilder();
                  var8 = 1;

                  while(true) {
                     if (var8 >= var4.length) {
                        var25 = var7.substring(0, var7.length() - 1);
                        if (var5) {
                           if (var25.length() > var6.cc()) {
                              break label732;
                           }
                        } else if (var25.length() > 4096) {
                           break label732;
                        }

                        if (!ai.idealistic.vacan.utils.minecraft.c.c.d(var5 ? var6.bC() : null, var25)) {
                           ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("failed_command").replace("{command}", g.a((Object[])var4, " ")), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                           return true;
                        }

                        ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("successful_command"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                        break;
                     }

                     var7.append(var4[var8]).append(" ");
                     ++var8;
                  }
               } else {
                  String var11;
                  int var37;
                  if (var4.length == 2) {
                     String var24;
                     if (var4[0].equalsIgnoreCase("Wave")) {
                        var24 = var4[1];
                        if (var5 && !ai.idealistic.vacan.functionality.server.b.a(var6.bC(), Permission.WAVE)) {
                           ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                           return true;
                        }

                        if (var24.equalsIgnoreCase("Run")) {
                           if (d.getWaveList().length == 0) {
                              ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("empty_wave_list"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                              return true;
                           }

                           if (!d.eT()) {
                              ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("failed_command").replace("{command}", g.a((Object[])var4, " ")), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                           }
                        } else if (var24.equalsIgnoreCase("Clear")) {
                           d.clear();
                           ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("wave_clear_message"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                        } else if (var24.equalsIgnoreCase("List")) {
                           var1.sendMessage(ChatColor.GRAY + "Wave Queued Players" + ChatColor.DARK_GRAY + ":");
                           var1.sendMessage(d.eS());
                        } else {
                           d(var1, "moderation");
                        }
                     } else if (var5 && var4[0].equalsIgnoreCase("Info")) {
                        if (!ai.idealistic.vacan.functionality.server.b.a(var6.bC(), Permission.INFO)) {
                           ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                           return true;
                        }

                        ai.idealistic.vacan.functionality.server.c.jm.a(var6, ai.idealistic.vacan.utils.minecraft.c.a.a((String)var4[1], (CheckEnums.HackType)null));
                     } else {
                        boolean var26;
                        int var32;
                        CheckEnums.HackType[] var33;
                        Check var34;
                        CheckEnums.HackType var36;
                        CheckEnums.HackType var40;
                        if (var4[0].equalsIgnoreCase("Toggle")) {
                           var24 = var4[1];
                           if (var5 && !ai.idealistic.vacan.functionality.server.b.a(var6.bC(), Permission.MANAGE)) {
                              ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                              return true;
                           }

                           var26 = false;
                           var33 = CheckEnums.HackType.values();
                           var32 = var33.length;

                           for(var37 = 0; var37 < var32; ++var37) {
                              var40 = var33[var37];
                              if (var40.getCheck().getName().equalsIgnoreCase(var24)) {
                                 var24 = var40.toString();
                                 var26 = true;
                                 break;
                              }
                           }

                           if (var26) {
                              var36 = CheckEnums.HackType.valueOf(var24);
                              var34 = var36.getCheck();
                              if (var34.a((Check.DataType)null, (String)null)) {
                                 var34.a((Check.DataType)null, false);
                                 var11 = ai.idealistic.vacan.functionality.server.a.jb.m("check_disable_message");
                                 var11 = var5 ? ai.idealistic.vacan.utils.minecraft.c.a.a((OfflinePlayer)((Player)var1), var11, (CheckEnums.HackType)var36) : ai.idealistic.vacan.utils.minecraft.c.a.a(var11, var36);
                                 var1.sendMessage(var11);
                              } else {
                                 var34.a((Check.DataType)null, true);
                                 var11 = ai.idealistic.vacan.functionality.server.a.jb.m("check_enable_message");
                                 var11 = var5 ? ai.idealistic.vacan.utils.minecraft.c.a.a((OfflinePlayer)((Player)var1), var11, (CheckEnums.HackType)var36) : ai.idealistic.vacan.utils.minecraft.c.a.a(var11, var36);
                                 var1.sendMessage(var11);
                              }
                           } else {
                              ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("non_existing_check"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                           }
                        } else if (var4[0].equalsIgnoreCase("Toggle-Prevention")) {
                           var24 = var4[1];
                           if (var5 && !ai.idealistic.vacan.functionality.server.b.a(var6.bC(), Permission.MANAGE)) {
                              ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                              return true;
                           }

                           var26 = false;
                           var33 = CheckEnums.HackType.values();
                           var32 = var33.length;

                           for(var37 = 0; var37 < var32; ++var37) {
                              var40 = var33[var37];
                              if (var40.getCheck().getName().equalsIgnoreCase(var24)) {
                                 var24 = var40.toString();
                                 var26 = true;
                                 break;
                              }
                           }

                           if (var26) {
                              var36 = CheckEnums.HackType.valueOf(var24);
                              var34 = var36.getCheck();
                              if (var34.b((Check.DataType)null, (String)null)) {
                                 var34.b((Check.DataType)null, false);
                                 var11 = ai.idealistic.vacan.functionality.server.a.jb.m("check_silent_disable_message");
                                 var11 = var5 ? ai.idealistic.vacan.utils.minecraft.c.a.a((OfflinePlayer)((Player)var1), var11, (CheckEnums.HackType)var36) : ai.idealistic.vacan.utils.minecraft.c.a.a(var11, var36);
                                 var1.sendMessage(var11);
                              } else {
                                 var34.b((Check.DataType)null, true);
                                 var11 = ai.idealistic.vacan.functionality.server.a.jb.m("check_silent_enable_message");
                                 var11 = var5 ? ai.idealistic.vacan.utils.minecraft.c.a.a((OfflinePlayer)((Player)var1), var11, (CheckEnums.HackType)var36) : ai.idealistic.vacan.utils.minecraft.c.a.a(var11, var36);
                                 var1.sendMessage(var11);
                              }
                           } else {
                              ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("non_existing_check"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                           }
                        } else if (var4[0].equalsIgnoreCase("Toggle-Punishment")) {
                           var24 = var4[1];
                           if (var5 && !ai.idealistic.vacan.functionality.server.b.a(var6.bC(), Permission.MANAGE)) {
                              ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                              return true;
                           }

                           var26 = false;
                           var33 = CheckEnums.HackType.values();
                           var32 = var33.length;

                           for(var37 = 0; var37 < var32; ++var37) {
                              var40 = var33[var37];
                              if (var40.getCheck().getName().equalsIgnoreCase(var24)) {
                                 var24 = var40.toString();
                                 var26 = true;
                                 break;
                              }
                           }

                           if (var26) {
                              var36 = CheckEnums.HackType.valueOf(var24);
                              var34 = var36.getCheck();
                              if (var34.a((Check.DataType)null)) {
                                 var34.c((Check.DataType)null, false);
                                 var11 = ai.idealistic.vacan.functionality.server.a.jb.m("check_punishment_disable_message");
                                 var11 = var5 ? ai.idealistic.vacan.utils.minecraft.c.a.a((OfflinePlayer)((Player)var1), var11, (CheckEnums.HackType)var36) : ai.idealistic.vacan.utils.minecraft.c.a.a(var11, var36);
                                 var1.sendMessage(var11);
                              } else {
                                 var34.c((Check.DataType)null, true);
                                 var11 = ai.idealistic.vacan.functionality.server.a.jb.m("check_punishment_enable_message");
                                 var11 = var5 ? ai.idealistic.vacan.utils.minecraft.c.a.a((OfflinePlayer)((Player)var1), var11, (CheckEnums.HackType)var36) : ai.idealistic.vacan.utils.minecraft.c.a.a(var11, var36);
                                 var1.sendMessage(var11);
                              }
                           } else {
                              ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("non_existing_check"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                           }
                        } else if (var5 && var4[0].equalsIgnoreCase("Notifications")) {
                           if (!ai.idealistic.vacan.functionality.c.c.s(var6)) {
                              ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                              return true;
                           }

                           var24 = var4[1];
                           if (ai.idealistic.vacan.utils.b.a.al(var24)) {
                              var8 = Integer.parseInt(var24);
                              if (var8 >= 0) {
                                 ai.idealistic.vacan.functionality.c.c.c(var6, var8);
                              } else {
                                 ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("failed_command").replace("{command}", g.a((Object[])var4, " ")), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                              }
                           } else {
                              ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("failed_command").replace("{command}", g.a((Object[])var4, " ")), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                           }
                        } else {
                           d(var1, "default");
                        }
                     }
                  } else {
                     var7 = new StringBuilder();

                     for(var8 = 2; var8 < var4.length; ++var8) {
                        var7.append(var4[var8]).append(" ");
                     }

                     var25 = var7.substring(0, var7.length() - 1);
                     c var27;
                     if (var4[0].equalsIgnoreCase("Kick")) {
                        if (var5 && !ai.idealistic.vacan.functionality.server.b.a(var6.bC(), Permission.KICK)) {
                           ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                           return true;
                        }

                        label624: {
                           if (var5) {
                              if (var25.length() <= var6.cc()) {
                                 break label624;
                              }
                           } else if (var25.length() <= 4096) {
                              break label624;
                           }

                           ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("massive_command_reason"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                           return true;
                        }

                        var27 = ai.idealistic.vacan.functionality.server.c.Q(var4[1]);
                        if (var27 == null) {
                           ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("player_not_found_message"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                           return true;
                        }

                        if (!var27.gj.a(var1, var25)) {
                           ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("failed_command").replace("{command}", g.a((Object[])var4, " ")), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                        }
                     } else if (var4[0].equalsIgnoreCase("Warn")) {
                        if (var5 && !ai.idealistic.vacan.functionality.server.b.a(var6.bC(), Permission.WARN)) {
                           ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                           return true;
                        }

                        label777: {
                           if (var5) {
                              if (var25.length() > var6.cc()) {
                                 break label777;
                              }
                           } else if (var25.length() > 4096) {
                              break label777;
                           }

                           var27 = ai.idealistic.vacan.functionality.server.c.Q(var4[1]);
                           if (var27 == null) {
                              ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("player_not_found_message"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                              return true;
                           }

                           if (!var27.gj.b(var1, var25)) {
                              ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("failed_command").replace("{command}", g.a((Object[])var4, " ")), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                           }

                           return false;
                        }

                        ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("massive_command_reason"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                        return true;
                     } else {
                        String var13;
                        if (var4[0].equalsIgnoreCase("Bypass")) {
                           boolean var29 = var4.length == 3;
                           if (!var29 && var4.length != 4) {
                              d(var1, "moderation");
                           } else {
                              CheckEnums.HackType[] var31 = CheckEnums.HackType.values();
                              var37 = var31.length;
                              String[] var39 = var4[2].split(",", var37);
                              var13 = var29 ? null : var4[3];
                              if (var5 && !ai.idealistic.vacan.functionality.server.b.a(var6.bC(), Permission.USE_BYPASS)) {
                                 ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                                 return true;
                              }

                              c var43 = ai.idealistic.vacan.functionality.server.c.Q(var4[1]);
                              if (var43 == null) {
                                 ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("player_not_found_message"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                                 return true;
                              }

                              ArrayList var15 = new ArrayList(var37);
                              String[] var16 = var39;
                              int var17 = var39.length;
                              int var18 = 0;

                              while(true) {
                                 String var19;
                                 if (var18 >= var17) {
                                    if (var15.isEmpty()) {
                                       ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("non_existing_check"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                                       break;
                                    }

                                    Iterator var41 = var15.iterator();

                                    while(var41.hasNext()) {
                                       CheckEnums.HackType var42 = (CheckEnums.HackType)var41.next();
                                       var18 = var29 ? 0 : Integer.parseInt(var13);
                                       if (var29) {
                                          var43.a(var42).a("Command-" + var1.getName(), (String)null, 0);
                                       } else {
                                          if (var18 < 1 || var18 > 3600) {
                                             var1.sendMessage(ChatColor.RED + "Seconds must be between 1 and 3600.");
                                             return true;
                                          }

                                          var43.a(var42).a("Command-" + var1.getName(), (String)null, var18 * ai.idealistic.vacan.utils.b.a.B(20.0D));
                                       }

                                       var19 = ai.idealistic.vacan.utils.minecraft.c.a.a(var43, ai.idealistic.vacan.functionality.server.a.jb.m("bypass_message"), var42).replace("{time}", var29 ? "infinite" : String.valueOf(var18));
                                       var1.sendMessage(var19);
                                    }

                                    return false;
                                 }

                                 var19 = var16[var18];
                                 CheckEnums.HackType[] var20 = var31;
                                 int var21 = var31.length;

                                 for(int var22 = 0; var22 < var21; ++var22) {
                                    CheckEnums.HackType var23 = var20[var22];
                                    if (var23.getCheck().getName().equalsIgnoreCase(var19)) {
                                       var15.add(var23);
                                       break;
                                    }
                                 }

                                 ++var18;
                              }
                           }
                        } else {
                           String var38;
                           if (var4[0].equalsIgnoreCase("Wave")) {
                              String var28 = var4[1];
                              OfflinePlayer var30 = Bukkit.getOfflinePlayer(var4[2]);
                              if (var5 && !ai.idealistic.vacan.functionality.server.b.a(var6.bC(), Permission.WAVE)) {
                                 ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                                 return true;
                              }

                              if (var28.equalsIgnoreCase("add") && var4.length >= 4) {
                                 if (d.getWaveList().length >= 100) {
                                    ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("full_wave_list"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                                    return true;
                                 }

                                 var7 = new StringBuilder();

                                 for(var37 = 3; var37 < var4.length; ++var37) {
                                    var7.append(var4[var37]).append(" ");
                                 }

                                 label778: {
                                    var25 = var7.substring(0, var7.length() - 1);
                                    if (var5) {
                                       if (var25.length() > var6.cc()) {
                                          break label778;
                                       }
                                    } else if (var25.length() > 4096) {
                                       break label778;
                                    }

                                    var11 = ai.idealistic.vacan.functionality.server.a.jb.m("wave_add_message");
                                    var11 = ai.idealistic.vacan.utils.minecraft.c.a.a((OfflinePlayer)var30, var11, (CheckEnums.HackType)null);
                                    var1.sendMessage(var11);
                                    d.b(var30.getUniqueId(), var25);
                                    return false;
                                 }

                                 ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("massive_command_reason"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                                 return true;
                              } else if (var28.equalsIgnoreCase("remove")) {
                                 UUID var35 = var30.getUniqueId();
                                 if (d.a(var35) == null) {
                                    var38 = ai.idealistic.vacan.functionality.server.a.jb.m("wave_not_added_message");
                                    var38 = ai.idealistic.vacan.utils.minecraft.c.a.a((OfflinePlayer)var30, var38, (CheckEnums.HackType)null);
                                    var1.sendMessage(var38);
                                    return true;
                                 }

                                 d.b(var35);
                                 var38 = ai.idealistic.vacan.functionality.server.a.jb.m("wave_remove_message");
                                 var38 = ai.idealistic.vacan.utils.minecraft.c.a.a((OfflinePlayer)var30, var38, (CheckEnums.HackType)null);
                                 var1.sendMessage(var38);
                              } else {
                                 d(var1, "moderation");
                              }
                           } else if (var4.length >= 4) {
                              var7 = new StringBuilder();

                              for(int var9 = 3; var9 < var4.length; ++var9) {
                                 var7.append(var4[var9]).append(" ");
                              }

                              var7.substring(0, var7.length() - 1);
                              if (var4.length >= 7) {
                                 if (var5 && !ai.idealistic.vacan.functionality.server.b.a(var6.bC(), Permission.CONDITION)) {
                                    ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                                    return true;
                                 }

                                 var27 = ai.idealistic.vacan.functionality.server.c.Q(var4[0]);
                                 if (var27 == null) {
                                    ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("player_not_found_message"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
                                    return true;
                                 }

                                 if (var4[1].equalsIgnoreCase("if") && var4[5].equalsIgnoreCase("do")) {
                                    String var10 = ai.idealistic.vacan.utils.minecraft.c.a.a((c)var27, var4[2], (CheckEnums.HackType)null);
                                    var11 = ai.idealistic.vacan.utils.minecraft.c.a.a((c)var27, var4[4], (CheckEnums.HackType)null);
                                    var7 = new StringBuilder();

                                    for(int var12 = 6; var12 < var4.length; ++var12) {
                                       var7.append(var4[var12]).append(" ");
                                    }

                                    var38 = ai.idealistic.vacan.utils.minecraft.c.a.a((c)var27, var7.substring(0, var7.length() - 1), (CheckEnums.HackType)null);
                                    var13 = var4[3].toLowerCase();
                                    byte var14 = -1;
                                    switch(var13.hashCode()) {
                                    case -1295482945:
                                       if (var13.equals("equals")) {
                                          var14 = 0;
                                       }
                                       break;
                                    case -567445985:
                                       if (var13.equals("contains")) {
                                          var14 = 4;
                                       }
                                       break;
                                    case -369640617:
                                       if (var13.equals("is-greater-than")) {
                                          var14 = 7;
                                       }
                                       break;
                                    case 60:
                                       if (var13.equals("<")) {
                                          var14 = 6;
                                       }
                                       break;
                                    case 61:
                                       if (var13.equals("=")) {
                                          var14 = 1;
                                       }
                                       break;
                                    case 62:
                                       if (var13.equals(">")) {
                                          var14 = 8;
                                       }
                                       break;
                                    case 1518:
                                       if (var13.equals("/=")) {
                                          var14 = 3;
                                       }
                                       break;
                                    case 244443250:
                                       if (var13.equals("is-less-than")) {
                                          var14 = 5;
                                       }
                                       break;
                                    case 1384381433:
                                       if (var13.equals("not-equals")) {
                                          var14 = 2;
                                       }
                                    }

                                    switch(var14) {
                                    case 0:
                                    case 1:
                                       if (var10.equalsIgnoreCase(var11)) {
                                          ai.idealistic.vacan.functionality.server.c.R(var38);
                                       }
                                       break;
                                    case 2:
                                    case 3:
                                       if (!var10.equalsIgnoreCase(var11)) {
                                          ai.idealistic.vacan.functionality.server.c.R(var38);
                                       }
                                       break;
                                    case 4:
                                       if (var10.contains(var11)) {
                                          ai.idealistic.vacan.functionality.server.c.R(var38);
                                       }
                                       break;
                                    case 5:
                                    case 6:
                                       if (ai.idealistic.vacan.utils.b.a.al(var10) && ai.idealistic.vacan.utils.b.a.al(var11) && G(var10) < G(var11) || ai.idealistic.vacan.utils.b.a.ao(var10) && ai.idealistic.vacan.utils.b.a.ao(var11) && H(var10) < H(var11) || ai.idealistic.vacan.utils.b.a.al(var10) && ai.idealistic.vacan.utils.b.a.ao(var11) && (double)G(var10) < H(var11) || ai.idealistic.vacan.utils.b.a.ao(var10) && ai.idealistic.vacan.utils.b.a.al(var11) && H(var10) < (double)G(var11)) {
                                          ai.idealistic.vacan.functionality.server.c.R(var38);
                                       }
                                       break;
                                    case 7:
                                    case 8:
                                       if (ai.idealistic.vacan.utils.b.a.al(var10) && ai.idealistic.vacan.utils.b.a.al(var11) && G(var10) > G(var11) || ai.idealistic.vacan.utils.b.a.ao(var10) && ai.idealistic.vacan.utils.b.a.ao(var11) && H(var10) > H(var11) || ai.idealistic.vacan.utils.b.a.al(var10) && ai.idealistic.vacan.utils.b.a.ao(var11) && (double)G(var10) > H(var11) || ai.idealistic.vacan.utils.b.a.ao(var10) && ai.idealistic.vacan.utils.b.a.al(var11) && H(var10) > (double)G(var11)) {
                                          ai.idealistic.vacan.functionality.server.c.R(var38);
                                       }
                                    }
                                 }
                              } else {
                                 d(var1, "default");
                              }
                           } else {
                              d(var1, "default");
                           }
                        }
                     }
                  }
               }
            }
         }

         return false;
      }

      ai.idealistic.vacan.functionality.c.a.b.b(var1, ai.idealistic.vacan.functionality.server.a.jb.m("massive_command_reason"), "Click to receive plugin support.", "https://www.idealistic.ai/discord/vacan");
      return true;
   }
}
