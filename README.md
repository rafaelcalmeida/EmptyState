![](https://img.shields.io/badge/Platform-Android-brightgreen.svg)
![](https://img.shields.io/hexpm/l/plug.svg)
![](https://img.shields.io/badge/version-1.0-blue.svg)

# EmptyView para Android
Permite implementar a exibição de estados vazios e de erro de forma simples e totalmente personalizável. Estados vazios podem exibir uma grande variedade de conteúdo.
Por exemplo, eles podem incluir uma pesquisa que não retorna resultados ou uma falha na conexão ao iniciar a busca de dados na rede. Embora esses estados não sejam típicos,
eles devem ser projetados para evitar confusão e ajudar o usuário a entender rapidamente o que ocorreu.

<img src="/art/banner.jpg" width="100%" alt="Android EmptyView / EmptyState"/>

## Star
Não esqueça de dar seu star, espero que essa library seja de grande ajuda em seu projeto.

## Adicionando ao projeto

```Gradle
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

```Gradle
dependencies {
    implementation 'com.github.rafaelcalmeida:emptystate:1.0'
}
```

## Como usar

Em seu xml
```xml
<br.com.rca.emptystate.ui.EmptyView
    android:id="@+id/emptyView"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```

Em sua Activity
```Kotlin
private val emptyState: EmptyState by lazy {
    val state = EmptyState()
    state.imageRes = R.drawable.ic_phone_wifi
    state.title = "No connection found."
    state.message = "Please check your internet connectivity and try again."
    state.labelButton = "Retry"
    state.actionHandler = {
        doAction()
     }

    state
}
```

```Kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    ...
    emptyView?.emptyState = emptyState
}
```

### 1. Atributos do EmptyState
| Atributo        | Descrição  |
| ------------- | ------------- |
| var title: String? | Texto do título |
| var titleRes: Int? | Texto do título, referência de StringRes |
| var message: String? | Texto da mensagem |
| var messageRes: Int? | Texto da mensagem, referência de StringRes |
| var labelButton: String? | Texto do botão |
| var labelButtonRes: Int? | Texto do botão, referência de StringRes |
| var actionHandler: (() -> Unit)? | Handler para receber callback dos cliques no botão |
| var imageRes: Int? | Imagem, referência DrawableRes |
| var imageColor: Int? | Cor da imagem |
| var imageColorRes: Int? | Cor da imagem, referência de ColorRes |
| var titleColor: Int? | Cor do texto do título |
| var titleColorRes: Int? | Cor do texto do título, referência de ColorRes |
| var messageColor: Int? | Cor do texto da mensagem |
| var messageColorRes: Int? | Cor do texto da mensagem, referência de ColorRes |
| var labelButtonColor: Int? | Cor do texto do botão |
| var labelButtonColorRes: Int? | Cor do texto do botão, referência de ColorRes |


### 2. Atributos da EmptyView
| Atributo        | Descrição  |
| ------------- | ------------- |
| var emptyState: EmptyState? | Representação dos atributos e métodos da EmptyView |
| var title: String? | Texto do título |
| var message: String? | Texto da mensagem |
| var labelButton: String? | Texto do botão|
| var actionHandler: (() -> Unit)? | Handler para receber callback dos cliques no botão |
| var imageColor: Int? | Cor da imagem |
| var titleColor: Int? | Cor do título |
| var messageColor: Int? | Cor da mensagem |
| var labelButtonColor: Int? | Cor do texto do botão |


### 3. Métodos da EmptyView
| Metódo        | Descrição  |
| ------------- | ------------- |
| fun setTitleRes(@StringRes resId: Int) | Configura o texto do título |
| fun setMessageRes(@StringRes resId: Int) | Configura o texto da mensagem |
| fun setLabelButtonRes(@StringRes resId: Int) | Configurar o texto do botão |
| fun setImageRes(@DrawableRes resId: Int?) | Configurar a imagem |
| fun setImageColorRes(@ColorRes resId: Int?) | Configura a cor da imagem |
| fun setTitleColorRes(@ColorRes resId: Int?) | Configura a cor da do título |
| fun setMessageColorRes(@ColorRes resId: Int?) | Configura a cor da mensagem |
| fun setLabelButtonColorRes(@ColorRes resId: Int?) | Configura a cor do texto do botão |
| fun reset() | Reinicia a EmptyView ao seu estado inicial |

## Contribuição
Pull requests com cobertura de testes são bem-vindos e incentivados.

## Bugs
Se você encontrar algum erro, por favor, registre uma [issue](https://github.com/rafaelcalmeida/EmptyState/issues).

## ProGuard
Não necessita de nenhuma configuração.

## Licença
~~~
The Apache License, Version 2.0
Copyright (c) 2020 Rafael de Carvalho Almeida

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
~~~
