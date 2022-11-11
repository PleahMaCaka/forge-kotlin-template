# 🪵 Minecraft Forge ⚒ Kotlin Template 💜

| INCLUDED       | INFO                                            |
|----------------|-------------------------------------------------|
| KotlinForForge | https://github.com/thedarkcolour/KotlinForForge |
| ParchmentMC    | https://github.com/ParchmentMC                  |
| Kotlin         | https://kotlinlang.org                          |

## Features

- Initialization
    - [Items](./src/main/kotlin/common/init/ItemInit.kt) and
      [Blocks](./src/main/kotlin/common/init/BlockInit.kt),
      [BlockItems](./src/main/kotlin/common/init/BlockItemInit.kt)
- Examples
    - [Example Item](./src/main/kotlin/common/item/SadObsidianMaker.kt)
    - [Example Block](./src/main/kotlin/common/block/ExampleBlock.kt)
    - [Example Creative Tab](./src/main/kotlin/ExampleMod.kt#L41)
    - Key Binds (Shortcuts)
        - [KeyBinds](./src/main/kotlin/common/keybind/KeyBinds.kt),
          [Handler](./src/main/kotlin/common/keybind/KeyBindHandler.kt)
- Mixin
    - [General mixin example](./src/main/java/mixin/ExampleMixin.java)
    - [Mixin kotlin binding](./src/main/java/mixin/bindings/ExampleBindingMixin.java)
      ㅡ [actually executed function](./src/main/kotlin/mixinkt/ExampleMixinBinding.kt)
