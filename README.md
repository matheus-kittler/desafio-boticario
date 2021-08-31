# Desafio Boticário

App com cadastro e login, mostrando uma lista mockada, uma lista consumida da API e dados do desenvolvedor.

# Como usar?

Primeiro, abra seu git bash ou terminal preferido, depois disso, execute este comando:

```bash
git clone https://github.com/matheus-kittler/testLoginAndNews.git
```


Agora com o projeto em sua máquina, seria interessante utilizar o Android Studio para ver os fonts e também para emular o app.
Após abrir o Android Studio vá em File > Open... > pasta onde você clonou o app quando utilizou o git bash ou terminal.

caso não saiba executar um app:


[Executar em um dispositivo real](https://developer.android.com/training/basics/firstapp/running-app?hl=pt-br)

e

[Executar um app no Android Emulator](https://developer.android.com/studio/run/emulator?hl=pt-br)

# Disponibilização

Também deixei um link no Google Drive para baixar a apk do app, no App Distribution do Firebase

[App in Drive](https://drive.google.com/drive/u/0/folders/1-3QEiJU3i2G9nYZMBk1FMSYYIMW0PO9L)

[App Distribution](https://appdistribution.firebase.dev/i/4ad9c0c62e7bf1fd)


# Arquitetura e Frameworks

Projeto com arquitetura MVVM onde estão sendo utilizando as bibliotecas Retrofit, Koin para injeção de dependência, Glide e Fragmets Extensions.

O app também está com o firebase implementado onde eu utilizei o Authentication para fazer o cadastro e login para facilitar.


O retrofit é utilizado primeiramente por ser mais simples a implementação do que o AsyncTask, além de por ser fácil de recuperar e fazer upload.
Também é a forma que aprendi mais efetiva durante meu estágio de consumir e dados JSON.

Uma das libs que utilizo no app é o NetWork de um amigo [Lucas Torres](https://github.com/LTMezzari/kotlin-network) para o Retrofit

Utilizei o Koin para testar minhas habilidades e também trabalhar com injeção de dependência, algo que não faço ultimamente, além de melhorar meu código.

Já no caso do Glide, utilizei ele por ser a opção que baixa mais rápido as imagens na rede comparado ao Picasso, por exemplo.
Glide foi o que mais tive contato quando estava tratando com imagens em projetos no meu estágio.
