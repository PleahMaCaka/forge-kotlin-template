# 🪵 Minecraft Forge ⚒ Kotlin Template 💜

## 1.19.4 Support

| INCLUDED       | INFO                                            |
|----------------|-------------------------------------------------|
| KotlinForForge | https://github.com/thedarkcolour/KotlinForForge |
| ParchmentMC    | https://github.com/ParchmentMC                  |
| Kotlin         | https://kotlinlang.org                          |

## Features

- Initialization
    - [Items](./src/main/kotlin/common/init/ItemRegistry.kt) and
      [Blocks](./src/main/kotlin/common/init/BlockRegistry.kt),
      [BlockItems](./src/main/kotlin/common/init/BlockItemRegistry.kt)
- Examples
    - [Example Item](./src/main/kotlin/common/items/SadObsidianMaker.kt)
    - [Example Block](./src/main/kotlin/common/blocks/ExampleBlock.kt)
    - [Example Creative Tab](./src/main/kotlin/common/creativetabs/ExampleCreativeModTab.kt)
    - KeyBinds (Shortcuts)
        - [KeyBinds](./src/main/kotlin/common/keybind/KeyBinds.kt),
          [Handler](./src/main/kotlin/common/keybind/KeyBindHandler.kt)
- Mixin
    - [General mixin example](./src/main/java/mixin/ExampleMixin.java)
    - [Mixin kotlin binding](./src/main/java/mixin/bindings/ExampleBindingMixin.java)
      ㅡ [actually executed function](./src/main/kotlin/mixinkt/ExampleMixinBinding.kt)