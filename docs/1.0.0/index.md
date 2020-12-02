---
layout: default
title: RezxisPluginChecker APIドキュメント
description: ドキュメントバージョン v1.0.0
---
# RezxisPluginChecker v1.0.0 APIドキュメント
## public static List\<Plugin> getMatchedplugins()
Rezxisのバージョンと一致しているプラグイン(Plugin型)のListを返します。  
ソースコード: [jp.iku55.rpc.Main:114](https://github.com/iku55/RezxisPluginChecker/blob/922d5fa7332fc29c9f5bb9c00c3941d81743acf5/src/main/jp/iku55/rpc/Main.java#L114)
## public static List\<Plugin> getDifferentplugins()
Rezxisのバージョンと違うプラグイン(Plugin型)のListを返します。  
ソースコード: [jp.iku55.rpc.Main:118](https://github.com/iku55/RezxisPluginChecker/blob/922d5fa7332fc29c9f5bb9c00c3941d81743acf5/src/main/jp/iku55/rpc/Main.java#L118)
## public static List\<Plugin> getNotavailableplugins()
Rezxisで使用できないプラグイン(Plugin型)のListを返します。  
ソースコード: [jp.iku55.rpc.Main:122](https://github.com/iku55/RezxisPluginChecker/blob/922d5fa7332fc29c9f5bb9c00c3941d81743acf5/src/main/jp/iku55/rpc/Main.java#L122)
## public static List\<String> getMatchedplnames()
Rezxisのバージョンと一致しているプラグインの名前(String型)のListを返します。  
ソースコード: [jp.iku55.rpc.Main:126](https://github.com/iku55/RezxisPluginChecker/blob/922d5fa7332fc29c9f5bb9c00c3941d81743acf5/src/main/jp/iku55/rpc/Main.java#L126)
## public static List\<String> getDifferentplnames()
Rezxisのバージョンと違うプラグインの名前(String型)のListを返します。  
ソースコード: [jp.iku55.rpc.Main:130](https://github.com/iku55/RezxisPluginChecker/blob/922d5fa7332fc29c9f5bb9c00c3941d81743acf5/src/main/jp/iku55/rpc/Main.java#L130)
## public static List\<String> getNotavailableplnames()
Rezxisで使用できないプラグインの名前(String型)のListを返します。  
ソースコード: [jp.iku55.rpc.Main:134](https://github.com/iku55/RezxisPluginChecker/blob/922d5fa7332fc29c9f5bb9c00c3941d81743acf5/src/main/jp/iku55/rpc/Main.java#L134)
## public static List\<String> getYAMLVersion()
Rezxisプラグインバージョンリストのバージョンを取得した結果を1行ずつ返します。  
ソースコード: [jp.iku55.rpc.config.GetVer](https://github.com/iku55/RezxisPluginChecker/blob/922d5fa7332fc29c9f5bb9c00c3941d81743acf5/src/main/jp/iku55/rpc/config/GetVer.java#L12)
