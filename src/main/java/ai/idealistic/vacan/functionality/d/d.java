package ai.idealistic.vacan.functionality.d;

import ai.idealistic.vacan.Register;
import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.abstraction.check.e;
import ai.idealistic.vacan.abstraction.profiling.MiningHistory;
import java.io.File;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Material;
import org.bukkit.World.Environment;
import org.bukkit.configuration.file.YamlConfiguration;

public class d {
   private static boolean jF = false;
   public static final Map<Integer, Double> jG = new ConcurrentHashMap();
   public static Map<CheckEnums.HackType, Collection<Check.DataType>> jH = new ConcurrentHashMap();
   private static long jI = 0L;
   private static final Map<String, ai.idealistic.vacan.abstraction.profiling.a> jJ = new ConcurrentHashMap();
   private static final ai.idealistic.vacan.functionality.b.b.a jK = new ai.idealistic.vacan.functionality.b.b.a(1L);

   public static Collection<ai.idealistic.vacan.abstraction.profiling.a> fi() {
      return jJ.values();
   }

   public static ai.idealistic.vacan.abstraction.profiling.a T(String var0) {
      ai.idealistic.vacan.abstraction.profiling.a var1 = (ai.idealistic.vacan.abstraction.profiling.a)jJ.get(var0);
      if (var1 == null) {
         var1 = new ai.idealistic.vacan.abstraction.profiling.a(var0);
         jJ.put(var0, var1);
      }

      return var1;
   }

   public static ai.idealistic.vacan.abstraction.profiling.a U(String var0) {
      if (!jJ.isEmpty()) {
         Iterator var1 = jJ.entrySet().iterator();

         while(var1.hasNext()) {
            Entry var2 = (Entry)var1.next();
            if (((String)var2.getKey()).equalsIgnoreCase(var0)) {
               return (ai.idealistic.vacan.abstraction.profiling.a)var2.getValue();
            }
         }
      }

      return null;
   }

   public static ai.idealistic.vacan.abstraction.profiling.a y(ai.idealistic.vacan.abstraction.f.c var0) {
      ai.idealistic.vacan.abstraction.profiling.a var1 = (ai.idealistic.vacan.abstraction.profiling.a)jJ.get(var0.bC().getName());
      if (var1 == null) {
         var1 = new ai.idealistic.vacan.abstraction.profiling.a(var0);
         jJ.put(var0.bC().getName(), var1);
      }

      return var1;
   }

   private static void z(ai.idealistic.vacan.abstraction.f.c var0) {
      ai.idealistic.vacan.abstraction.profiling.a var1 = new ai.idealistic.vacan.abstraction.profiling.a(var0);
      var1.h(var0);
      jJ.put(var0.bC().getName(), new ai.idealistic.vacan.abstraction.profiling.a(var0));
   }

   public static void b(CheckEnums.HackType var0) {
      if (jF) {
         jK.f(() -> {
            String var1 = var0.toString();
            if (!jJ.isEmpty()) {
               ai.idealistic.vacan.abstraction.profiling.a var3;
               for(Iterator var2 = jJ.values().iterator(); var2.hasNext(); var3.bw().clear()) {
                  var3 = (ai.idealistic.vacan.abstraction.profiling.a)var2.next();
                  e var4 = var3.a(var0);
                  Iterator var5;
                  Check.DataType[] var7;
                  int var8;
                  int var9;
                  Check.DataType var10;
                  if (var4 != null) {
                     var5 = var4.getDetections().iterator();

                     while(var5.hasNext()) {
                        ai.idealistic.vacan.abstraction.check.b var16 = (ai.idealistic.vacan.abstraction.check.b)var5.next();
                        var7 = Check.DataType.values();
                        var8 = var7.length;

                        for(var9 = 0; var9 < var8; ++var9) {
                           var10 = var7[var9];
                           var16.b(var10);
                        }
                     }
                  } else {
                     var5 = var0.getDetections().iterator();

                     while(var5.hasNext()) {
                        String var6 = (String)var5.next();
                        var7 = Check.DataType.values();
                        var8 = var7.length;

                        for(var9 = 0; var9 < var8; ++var9) {
                           var10 = var7[var9];
                           var3.b(var0, var10, var6);
                        }
                     }
                  }
               }

               H(true);
            }

            if (ai.idealistic.vacan.functionality.server.a.ja.isEnabled()) {
               ai.idealistic.vacan.functionality.server.a.ja.o("DELETE FROM " + ai.idealistic.vacan.functionality.server.a.ja.aD() + " WHERE functionality = '" + var1 + "';");
            }

            Collection var12 = fk();
            if (!var12.isEmpty()) {
               Iterator var13 = var12.iterator();

               while(var13.hasNext()) {
                  File var14 = (File)var13.next();
                  YamlConfiguration var15 = YamlConfiguration.loadConfiguration(var14);
                  Iterator var17 = var15.getKeys(false).iterator();

                  while(var17.hasNext()) {
                     String var18 = (String)var17.next();
                     String var19 = var15.getString(var18);
                     if (var19 != null && var19.contains(var1)) {
                        var15.set(var18, (Object)null);
                     }
                  }

                  try {
                     var15.save(var14);
                  } catch (Exception var11) {
                  }
               }
            }

         });
      }

   }

   public static void V(String var0) {
      if (jF) {
         ai.idealistic.vacan.abstraction.f.c var1 = ai.idealistic.vacan.functionality.server.c.P(var0);
         if (fj()) {
            jK.f(() -> {
               if (var1 == null) {
                  jJ.remove(var0);
               } else {
                  z(var1);
               }

               if (ai.idealistic.vacan.functionality.server.a.ja.isEnabled()) {
                  ai.idealistic.vacan.functionality.server.a.ja.o("DELETE FROM " + ai.idealistic.vacan.functionality.server.a.ja.aD() + " WHERE information LIKE '%" + var0 + "%';");
               }

               Collection var2 = fk();
               if (!var2.isEmpty()) {
                  Iterator var3 = var2.iterator();

                  while(var3.hasNext()) {
                     File var4 = (File)var3.next();
                     YamlConfiguration var5 = YamlConfiguration.loadConfiguration(var4);
                     Iterator var6 = var5.getKeys(false).iterator();

                     while(var6.hasNext()) {
                        String var7 = (String)var6.next();
                        String var8 = var5.getString(var7);
                        if (var8 != null && var8.contains(var0)) {
                           var5.set(var7, (Object)null);
                        }
                     }

                     try {
                        var5.save(var4);
                     } catch (Exception var9) {
                     }
                  }
               }

            });
         } else if (var1 == null) {
            jJ.remove(var0);
         } else {
            z(var1);
         }

         ai.idealistic.vacan.functionality.server.c.jm.z(var0);
      }

   }

   public static String b(String var0, String var1) {
      String var2 = "(" + var1 + " ";
      int var3 = var0.indexOf(var2);
      if (var3 > -1) {
         var0 = var0.substring(var3 + var2.length());
         var3 = var0.indexOf(")");
         return var0.substring(0, var3);
      } else {
         return null;
      }
   }

   private static Check.DataType W(String var0) {
      var0 = b(var0, "Java:");
      if (var0 != null) {
         Check.DataType[] var1 = Check.DataType.values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            Check.DataType var4 = var1[var3];
            if (var0.equals(var4.toString())) {
               return var4;
            }
         }
      }

      return Check.DataType.JAVA;
   }

   private static boolean fj() {
      return ai.idealistic.vacan.functionality.server.a.iZ.i("Logs.log_file") || ai.idealistic.vacan.functionality.server.a.ja.isEnabled();
   }

   private static Collection<File> fk() {
      File[] var0 = (new File(a.jx)).listFiles();
      if (var0 != null && var0.length > 0) {
         TreeMap var1 = new TreeMap();
         String var2 = "log";
         String var3 = ".yml";
         int var4 = var2.length();
         int var5 = var3.length();
         File[] var6 = var0;
         int var7 = var0.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            File var9 = var6[var8];
            if (var9.isFile()) {
               String var10 = var9.getName();
               if (var10.startsWith(var2) && var10.endsWith(var3)) {
                  Integer var11 = ai.idealistic.vacan.utils.b.a.ak(var10.substring(var4, var10.length() - var5));
                  if (var11 != null) {
                     var1.put(var11, var9);
                  }
               }
            }
         }

         LinkedList var12 = new LinkedList(var1.values());
         Collections.reverse(var12);
         return var12;
      } else {
         return new ArrayList(0);
      }
   }

   private static Map<String, String> fl() {
      LinkedHashMap var0 = new LinkedHashMap();
      int var1 = 0;
      boolean var2 = false;
      boolean var3 = false;
      if (ai.idealistic.vacan.functionality.server.a.ja.isEnabled()) {
         try {
            ResultSet var4 = ai.idealistic.vacan.functionality.server.a.ja.p("SELECT creation_date, information FROM " + ai.idealistic.vacan.functionality.server.a.ja.aD() + " ORDER BY id DESC LIMIT " + ai.idealistic.vacan.functionality.server.c.jq + ";");
            if (var4 == null) {
               var3 = true;
            } else {
               while(var4.next()) {
                  String var5 = var4.getString("information");
                  String var6 = var4.getString("creation_date");
                  var0.put(var6, var5);
                  var1 += var6.length() + var5.length();
                  if (var1 >= ai.idealistic.vacan.functionality.server.c.jp) {
                     var2 = true;
                     break;
                  }
               }

               var4.close();
               if (var0.isEmpty()) {
                  var3 = true;
               }
            }
         } catch (Exception var11) {
            var3 = true;
         }
      } else {
         var3 = true;
      }

      if (!var2 && var3) {
         Collection var12 = fk();
         if (!var12.isEmpty()) {
            Iterator var13 = var12.iterator();

            while(var13.hasNext()) {
               File var14 = (File)var13.next();
               YamlConfiguration var7 = YamlConfiguration.loadConfiguration(var14);
               Iterator var8 = var7.getKeys(false).iterator();

               while(var8.hasNext()) {
                  String var9 = (String)var8.next();
                  String var10 = var7.getString(var9);
                  if (var10 != null) {
                     var0.put(var9, var10);
                     var1 += var9.length() + var10.length();
                     if (var1 >= ai.idealistic.vacan.functionality.server.c.jp) {
                        var2 = true;
                        break;
                     }
                  }
               }

               if (var2) {
                  break;
               }
            }
         }
      }

      return var0;
   }

   public static void refresh(boolean var0) {
      Runnable var1 = () -> {
         ai.idealistic.vacan.functionality.server.a.ja.aJ();
         if (var0) {
            fm();
            ai.idealistic.vacan.functionality.connection.a.eI();
         }

      };
      if (jF) {
         jK.e(var1);
      } else {
         jK.f(var1);
         jF = true;
      }

   }

   private static void fm() {
      String var7;
      if (fj()) {
         Map var0 = fl();
         if (!var0.isEmpty()) {
            Iterator var1 = var0.entrySet().iterator();

            label102:
            while(true) {
               while(true) {
                  String var3;
                  String var4;
                  String var5;
                  String var6;
                  do {
                     do {
                        while(true) {
                           if (!var1.hasNext()) {
                              break label102;
                           }

                           Entry var2 = (Entry)var1.next();
                           var3 = (String)var2.getKey();
                           var4 = (String)var2.getValue();
                           var5 = b(var4, "Detection:");
                           if (var5 != null) {
                              var6 = b(var4, "Check:");
                              break;
                           }

                           var6 = b(var4, "Ore: ");
                           if (var6 != null) {
                              var7 = b(var4, "Amount: ");
                              if (var7 != null && ai.idealistic.vacan.utils.b.a.al(var7)) {
                                 String var8 = b(var4, "Player:");
                                 if (var8 != null) {
                                    String var9 = b(var4, "Environment: ");
                                    if (var9 != null) {
                                       Material var10 = ai.idealistic.vacan.utils.minecraft.a.d.av(var6.toUpperCase().replace("-", "_"));
                                       if (var10 != null) {
                                          MiningHistory.MiningOre var11 = MiningHistory.b(var10);
                                          if (var11 != null) {
                                             Environment var12 = ai.idealistic.vacan.utils.minecraft.a.d.aw(var9.toUpperCase().replace("-", "_"));
                                             if (var12 != null) {
                                                T(var8).a(var11).a(var12, Integer.parseInt(var7));
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           } else {
                              int var25 = var4.indexOf(" was active for: ");
                              if (var25 != -1) {
                                 SimpleDateFormat var26 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSSXXX");

                                 try {
                                    T(var4.split(" ", 2)[0]).bw().a(var26.parse(var3).getTime(), Long.parseLong(var4.substring(var25 + " was active for: ".length())), false);
                                 } catch (Exception var16) {
                                 }
                              }
                           }
                        }
                     } while(var6 == null);

                     var7 = b(var4, "Player:");
                  } while(var7 == null);

                  CheckEnums.HackType[] var27 = CheckEnums.HackType.values();
                  int var28 = var27.length;

                  for(int var29 = 0; var29 < var28; ++var29) {
                     CheckEnums.HackType var30 = var27[var29];
                     if (var6.equals(var30.toString())) {
                        Check.DataType var31 = W(var4);
                        ai.idealistic.vacan.abstraction.profiling.a var13 = T(var7);
                        var13.h(var31);
                        SimpleDateFormat var14 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSSXXX");

                        try {
                           var30.addDetection(var5, 500L);
                           var13.a(var30, var31, var5, var14.parse(var3).getTime());
                        } catch (Exception var17) {
                        }
                        break;
                     }
                  }
               }
            }
         }
      }

      Iterator var18 = jJ.values().iterator();

      while(var18.hasNext()) {
         ai.idealistic.vacan.abstraction.profiling.a var19 = (ai.idealistic.vacan.abstraction.profiling.a)var18.next();
         CheckEnums.HackType[] var20 = CheckEnums.HackType.values();
         int var21 = var20.length;

         for(int var22 = 0; var22 < var21; ++var22) {
            CheckEnums.HackType var23 = var20[var22];
            Iterator var24 = var23.getDetections().iterator();

            while(var24.hasNext()) {
               var7 = (String)var24.next();
               var19.b(var23, var7);
            }
         }
      }

      H(true);
   }

   private static void H(boolean var0) {
      if ((var0 || !jH.isEmpty()) && !jJ.isEmpty()) {
         Collection var1 = jJ.values();
         Iterator var2 = ((Collection)(var0 ? Arrays.asList(CheckEnums.HackType.values()) : jH.keySet())).iterator();

         label188:
         while(var2.hasNext()) {
            CheckEnums.HackType var3 = (CheckEnums.HackType)var2.next();
            Collection var4 = (Collection)jH.get(var3);
            Iterator var5 = ((Collection)(var0 ? Arrays.asList(Check.DataType.values()) : (var4 != null && !var4.isEmpty() ? var4 : Arrays.asList(Check.DataType.values())))).iterator();

            while(true) {
               while(true) {
                  while(true) {
                     if (!var5.hasNext()) {
                        continue label188;
                     }

                     Check.DataType var6 = (Check.DataType)var5.next();
                     LinkedHashMap var7 = new LinkedHashMap();
                     Iterator var8;
                     ai.idealistic.vacan.abstraction.profiling.a var9;
                     Iterator var10;
                     String var11;
                     if (var3.getCheck().a((Check.DataType)var6, (String)null)) {
                        var8 = var1.iterator();

                        while(var8.hasNext()) {
                           var9 = (ai.idealistic.vacan.abstraction.profiling.a)var8.next();
                           var10 = var3.getDetections().iterator();

                           while(var10.hasNext()) {
                              var11 = (String)var10.next();
                              ((List)var7.computeIfAbsent(var11, (var0x) -> {
                                 return new ArrayList();
                              })).add(var9.a(var3, var6, var11));
                           }
                        }

                        double var12;
                        if (var7.isEmpty()) {
                           var8 = var1.iterator();

                           while(var8.hasNext()) {
                              var9 = (ai.idealistic.vacan.abstraction.profiling.a)var8.next();
                              var10 = var3.getDetections().iterator();

                              while(var10.hasNext()) {
                                 var11 = (String)var10.next();
                                 var9.b(var3, var6, var11);
                                 jG.remove(ai.idealistic.vacan.abstraction.check.b.a(var3, var11) * 31 + var6.hashCode());
                              }
                           }
                        } else {
                           label172:
                           for(var8 = var7.entrySet().iterator(); var8.hasNext(); jG.put(ai.idealistic.vacan.abstraction.check.b.a(var3, var11) * 31 + var6.hashCode(), Math.min(var12, (double)(var3.getDefaultAverageTime(var11) * 3L)))) {
                              Entry var25 = (Entry)var8.next();
                              List var26 = (List)var25.getValue();
                              var11 = (String)var25.getKey();
                              var12 = 0.0D;
                              double var14 = 0.0D;
                              double var16 = 0.0D;
                              double var18 = 0.0D;
                              Iterator var20 = var26.iterator();

                              while(true) {
                                 List var21;
                                 Iterator var22;
                                 long var23;
                                 do {
                                    if (!var20.hasNext()) {
                                       if (!(var16 > 0.0D)) {
                                          var14 = (double)var3.getDefaultAverageTime(var11);
                                       } else {
                                          var14 /= var16;
                                          var20 = var26.iterator();

                                          label157:
                                          while(true) {
                                             while(true) {
                                                if (!var20.hasNext()) {
                                                   break label157;
                                                }

                                                var21 = (List)var20.next();
                                                if (var21.isEmpty()) {
                                                   var12 += var14;
                                                   ++var18;
                                                } else {
                                                   for(var22 = var21.iterator(); var22.hasNext(); var12 += (double)var23) {
                                                      var23 = (Long)var22.next();
                                                   }

                                                   var18 += (double)var21.size();
                                                }
                                             }
                                          }
                                       }

                                       for(var20 = var26.iterator(); var20.hasNext(); var18 += (double)var21.size()) {
                                          var21 = (List)var20.next();

                                          for(var22 = var21.iterator(); var22.hasNext(); var12 += (double)var23) {
                                             var23 = (Long)var22.next();
                                          }
                                       }

                                       if (var18 > 0.0D) {
                                          var12 /= var18;
                                       } else {
                                          var12 = var14;
                                       }
                                       continue label172;
                                    }

                                    var21 = (List)var20.next();
                                 } while(var21.isEmpty());

                                 for(var22 = var21.iterator(); var22.hasNext(); var14 += (double)var23) {
                                    var23 = (Long)var22.next();
                                 }

                                 var16 += (double)var21.size();
                              }
                           }
                        }
                     } else {
                        var8 = var1.iterator();

                        while(var8.hasNext()) {
                           var9 = (ai.idealistic.vacan.abstraction.profiling.a)var8.next();
                           var10 = var3.getDetections().iterator();

                           while(var10.hasNext()) {
                              var11 = (String)var10.next();
                              var9.b(var3, var6, var11);
                              jG.remove(ai.idealistic.vacan.abstraction.check.b.a(var3, var11) * 31 + var6.hashCode());
                           }
                        }
                     }
                  }
               }
            }
         }

         jH.clear();
      }

   }

   public static void a(CheckEnums.HackType var0, Check.DataType var1) {
      ((Collection)jH.computeIfAbsent(var0, (var0x) -> {
         return new ai.idealistic.vacan.utils.a.a();
      })).add(var1);
   }

   public static double a(ai.idealistic.vacan.abstraction.check.b var0, Check.DataType var1) {
      double var2 = (Double)jG.getOrDefault(var0.h() * 31 + var1.hashCode(), (double)var0.N);
      return var2 > 0.0D ? var2 : (double)var0.N;
   }

   static {
      ai.idealistic.vacan.functionality.server.c.a(() -> {
         if (jF) {
            if (jI == 0L) {
               jI = 1200L;
               if (ai.idealistic.vacan.functionality.server.a.ja.isEnabled()) {
                  refresh(Register.isPluginEnabled());
               } else {
                  jK.e(() -> {
                     H(false);
                  });
               }
            } else {
               --jI;
               jK.e(() -> {
                  H(false);
               });
            }
         }

      }, 1L, 1L);
   }
}
