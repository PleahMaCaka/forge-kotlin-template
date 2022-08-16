# Minecraft Forge Kotlin Template

| INCLUDED       | INFO                                            |
|----------------|-------------------------------------------------|
| KotlinForForge | https://github.com/thedarkcolour/KotlinForForge |
| ParchmentMC    | https://github.com/ParchmentMC                  |
| Kotlin         | https://kotlinlang.org                          |

## Features

- [Key Binding (hotkey)](./src/main/kotlin/common/keybind/KeyBinding.kt)
- [Example Item](./src/main/kotlin/common/item/SadObsidianMaker.kt)
- [Example Block](./src/main/kotlin/common/block/ExampleBlock.kt) ㅡ [BlockInit](./src/main/kotlin/common/block/ExampleBlock.kt)
  / [BlockItem](./src/main/kotlin/common/init/ItemInit.kt) L28
- [Example Creative Tab](./src/main/kotlin/init/ExampleCreativeTab.kt)
- [Mixin Example](./src/main/java/com/pleahmacaka/examplemod/mixin/ExampleMixin.java)
- [Bind Mixins To Kotlin](./src/main/java/com/pleahmacaka/examplemod/mixin/bindings/CheckAround.java)
  ㅡ [Actually Executed Function](./src/main/kotlin/mixinkt/CanAttackStuff.kt)
