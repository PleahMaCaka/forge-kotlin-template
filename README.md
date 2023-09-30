# 🪵 Minecraft Forge ⚒ Kotlin Template 💜

## 🌟 1.20.2 Support 🌟

| INCLUDED       | INFO                                            |
|----------------|-------------------------------------------------|
| KotlinForForge | https://github.com/thedarkcolour/KotlinForForge |
| ParchmentMC    | https://github.com/ParchmentMC                  |
| Kotlin         | https://kotlinlang.org                          |

## 🛠️ Getting Started 🛠️

| 1. Gradle Tasks -> forgegradle runs <br/>-> `gen<your IDE>Runs`                                                                          | 2. Run `runClient` <br/>in your IDE's Run / Debug Configuration                                                                                                                                                                                                                                                                                                  |
|------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| <div align="center">![genRunConfig](https://cdn.discordapp.com/attachments/1072301775606001744/1088421409967050833/image.png)</div>      | <div align="center">![runClient](https://cdn.discordapp.com/attachments/1072301775606001744/1088424141801140244/image.png)</div>                                                                                                                                                                                                                                 |
| <div align="center"> HotSwap in debug mode [LEARN MORE](https://forge.gemwire.uk/wiki/Hotswap)</div>                                     | <div align="center">Useful References</div>                                                                                                                                                                                                                                                                                                                      |
| <div align="center"><img width=350 src="https://cdn.discordapp.com/attachments/1072301775606001744/1088424637542703205/image.png"></div> | <div align="center"><a href="https://forge.gemwire.uk/wiki/Main_Page"><img width=260 src="https://cdn.discordapp.com/attachments/1072301775606001744/1088426016495644752/image.png"></a><br/><a href="https://docs.minecraftforge.net/en/1.19.x/"><img src="https://cdn.discordapp.com/attachments/1072301775606001744/1088426119876845578/image.png"></a></div> |

## ⚙️ Features ⚙️

- Initialization
    - [Item](./src/main/kotlin/init/ItemRegistry.kt),
      [Block](./src/main/kotlin/init/BlockRegistry.kt) -
      [BlockItem](./src/main/kotlin/init/BlockItemRegistry.kt)
- Examples
    - [Example Item](./src/main/kotlin/items/SadObsidianMaker.kt)
    - [Example Block](./src/main/kotlin/blocks/ExampleBlock.kt)
    - [Example Creative Tab](./src/main/kotlin/creativetabs/ExampleCreativeModTab.kt)
    - [KeyBinds](./src/main/kotlin/keybind/KeyBinds.kt) ㅡ
      [Handler](./src/main/kotlin/keybind/KeyBindHandler.kt)
- Mixin
    - [General Mixin Example (Java)](./src/main/java/mixin/ExampleMixin.java)
    - [Mixin Kotlin Binding](./src/main/java/mixin/bindings/ExampleBindingMixin.java)
      ㅡ [actually executed function](./src/main/kotlin/mixinkt/ExampleMixinBinding.kt)
