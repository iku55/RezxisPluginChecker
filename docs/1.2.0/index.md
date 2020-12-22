# RezxisPluginChecker v1.2.0 APIドキュメント
## public static List\<Plugin> getMatchedplugins()
Rezxisのバージョンと一致しているプラグイン(Plugin型)のListを返します。  
ソースコード: [jp.iku55.rpc.Main:111](https://github.com/iku55/RezxisPluginChecker/blob/81c2f4b3a17a07d11b9ae7dd7ecf9f4f525f92b4/src/main/jp/iku55/rpc/Main.java#L111)
## public static List\<Plugin> getDifferentplugins()
Rezxisのバージョンと違うプラグイン(Plugin型)のListを返します。  
ソースコード: [jp.iku55.rpc.Main:121](https://github.com/iku55/RezxisPluginChecker/blob/81c2f4b3a17a07d11b9ae7dd7ecf9f4f525f92b4/src/main/jp/iku55/rpc/Main.java#L121)
## public static List\<Plugin> getNotavailableplugins()
Rezxisで使用できないプラグイン(Plugin型)のListを返します。  
ソースコード: [jp.iku55.rpc.Main:131](https://github.com/iku55/RezxisPluginChecker/blob/81c2f4b3a17a07d11b9ae7dd7ecf9f4f525f92b4/src/main/jp/iku55/rpc/Main.java#L131)
## public static LinkedHashMap<String, PluginVersions> getPlversions()
versions.ymlの内容をStringとPluginVersionsのLinkedHashMapにしたものを返します。  
ソースコード: [jp.iku55.rpc.Main:141](https://github.com/iku55/RezxisPluginChecker/blob/81c2f4b3a17a07d11b9ae7dd7ecf9f4f525f92b4/src/main/jp/iku55/rpc/Main.java#L141)
## public static TextComponent generatePluginList(List<Plugin> plugins, LinkedHashMap<String, PluginVersions> plversions)
/pllistで使用されているプラグインを[, ]でつなげたTextComponentを生成して返します。  
ソースコード: [jp.iku55.rpc.GenPluginList:15](https://github.com/iku55/RezxisPluginChecker/blob/81c2f4b3a17a07d11b9ae7dd7ecf9f4f525f92b4/src/main/jp/iku55/rpc/GenPluginList.java#L15)
### 引数
#### List<Plugin> plugins
Pluginのリスト。
#### LinkedHashMap<String, PluginVersions> plversions
プラグイン名とPluginVersionsが関連付けられているLinkedHashMap。  
通常はjp.iku55.rpc.Main.getPlversions()を使用してください。
## public static List\<String> getYAMLVersion()
Rezxisプラグインバージョンリストのバージョンを取得した結果を1行ずつ返します。  
ソースコード: [jp.iku55.rpc.config.GetVer:14](https://github.com/iku55/RezxisPluginChecker/blob/81c2f4b3a17a07d11b9ae7dd7ecf9f4f525f92b4/src/main/jp/iku55/rpc/config/GetVer.java#L14)
## public static void setup()
Rezxisプラグインバージョンリスト(コンフィグ)をセットアップします。  
ソースコード: [jp.iku55.rpc.config.PluginVersionsList:18](https://github.com/iku55/RezxisPluginChecker/blob/81c2f4b3a17a07d11b9ae7dd7ecf9f4f525f92b4/src/main/jp/iku55/rpc/config/PluginVersionsList.java#L18)
## public static FileConfiguration get()
Rezxisプラグインバージョンリスト(コンフィグ)を返します。  
ソースコード: [jp.iku55.rpc.config.PluginVersionsList:32](https://github.com/iku55/RezxisPluginChecker/blob/81c2f4b3a17a07d11b9ae7dd7ecf9f4f525f92b4/src/main/jp/iku55/rpc/config/PluginVersionsList.java#L32)
## public static void save()
Rezxisプラグインバージョンリスト(コンフィグ)をセーブします。  
ソースコード: [jp.iku55.rpc.config.PluginVersionsList:36](https://github.com/iku55/RezxisPluginChecker/blob/81c2f4b3a17a07d11b9ae7dd7ecf9f4f525f92b4/src/main/jp/iku55/rpc/config/PluginVersionsList.java#L36)
## public static void reload()
Rezxisプラグインバージョンリスト(コンフィグ)をリロードします。  
ソースコード: [jp.iku55.rpc.config.PluginVersionsList:47](https://github.com/iku55/RezxisPluginChecker/blob/81c2f4b3a17a07d11b9ae7dd7ecf9f4f525f92b4/src/main/jp/iku55/rpc/config/PluginVersionsList.java#L47)
## public static void downloadVersionsYAML()
Rezxisプラグインバージョンリスト(コンフィグ)をダウンロードします。  
ソースコード: [jp.iku55.rpc.config.DownloadYAML:20](https://github.com/iku55/RezxisPluginChecker/blob/81c2f4b3a17a07d11b9ae7dd7ecf9f4f525f92b4/src/main/jp/iku55/rpc/config/DownloadYAML.java#L20)
