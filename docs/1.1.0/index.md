---
layout: default
title: RezxisPluginChecker APIドキュメント
description: ドキュメントバージョン v1.0.0
---
# RezxisPluginChecker v1.1.0 APIドキュメント
## public static List\<Plugin> getMatchedplugins()
Rezxisのバージョンと一致しているプラグイン(Plugin型)のListを返します。  
ソースコード: [jp.iku55.rpc.Main:117](https://github.com/iku55/RezxisPluginChecker/blob/fdb32b925c675da545a466f78ff8c51f11fa5401/src/main/jp/iku55/rpc/Main.java#L117)
## public static List\<Plugin> getDifferentplugins()
Rezxisのバージョンと違うプラグイン(Plugin型)のListを返します。  
ソースコード: [jp.iku55.rpc.Main:121](https://github.com/iku55/RezxisPluginChecker/blob/fdb32b925c675da545a466f78ff8c51f11fa5401/src/main/jp/iku55/rpc/Main.java#L121)
## public static List\<Plugin> getNotavailableplugins()
Rezxisで使用できないプラグイン(Plugin型)のListを返します。  
ソースコード: [jp.iku55.rpc.Main:125](https://github.com/iku55/RezxisPluginChecker/blob/fdb32b925c675da545a466f78ff8c51f11fa5401/src/main/jp/iku55/rpc/Main.java#L125)
## public static List\<String> getMatchedplnames()
Rezxisのバージョンと一致しているプラグインの名前(String型)のListを返します。  
⚠︎ 次のバージョンで廃止されます  
ソースコード: [jp.iku55.rpc.Main:129](https://github.com/iku55/RezxisPluginChecker/blob/fdb32b925c675da545a466f78ff8c51f11fa5401/src/main/jp/iku55/rpc/Main.java#L129)
## public static List\<String> getDifferentplnames()
Rezxisのバージョンと違うプラグインの名前(String型)のListを返します。  
⚠︎ 次のバージョンで廃止されます  
ソースコード: [jp.iku55.rpc.Main:133](https://github.com/iku55/RezxisPluginChecker/blob/fdb32b925c675da545a466f78ff8c51f11fa5401/src/main/jp/iku55/rpc/Main.java#L133)
## public static List\<String> getNotavailableplnames()
Rezxisで使用できないプラグインの名前(String型)のListを返します。  
⚠︎ 次のバージョンで廃止されます  
ソースコード: [jp.iku55.rpc.Main:137](https://github.com/iku55/RezxisPluginChecker/blob/fdb32b925c675da545a466f78ff8c51f11fa5401/src/main/jp/iku55/rpc/Main.java#L137)
## public static List\<String> getYAMLVersion()
Rezxisプラグインバージョンリストのバージョンを取得した結果を1行ずつ返します。  
ソースコード: [jp.iku55.rpc.config.GetVer:12](https://github.com/iku55/RezxisPluginChecker/blob/fdb32b925c675da545a466f78ff8c51f11fa5401/src/main/jp/iku55/rpc/config/GetVer.java#L12)
