🛒 SGI-MS: Sistema de Gestão Integrada para Mini-Supermercados
Sistema completo para controle de vendas, estoque e gestão de clientes, fornecedores e funcionários, desenvolvido com Java e MySQL.


🟢 Status do Projeto
[STATUS: Concluído / Em Manutenção / Em Desenvolvimento]

✨ Funcionalidades
O projeto oferece módulos essenciais para a operação de um mini-supermercado:

Segurança e Acesso
Autenticação de Usuário: Login com níveis de acesso (Admin x Usuário/Funcionário).

Validação de CPF: Lógica de negócio implementada para verificar a validade do CPF em cadastros de Clientes e Funcionários.

Módulos Principais
Clientes: CRUD completo (Cadastro, Consulta, Edição e Exclusão).

Fornecedores: CRUD para gestão dos parceiros comerciais.

Produtos: CRUD de produtos com campos para preço, custo e estoque mínimo.

Funcionários: Cadastro e gerenciamento de colaboradores.

Vendas: Registro de transações, criação de Itens de Venda e cálculo automático do total.

Gerenciamento de Estoque (Destaque)
Baixa Automática: O estoque é automaticamente decrementado após cada venda registrada.

Alerta de Nível Mínimo: Exibe um alerta visual ou em relatório quando a quantidade em estoque de um produto atinge o limite mínimo definido.

💻 Tecnologias Utilizadas
📐 Arquitetura do Projeto
O código-fonte está organizado seguindo o padrão MVC (Model-View-Controller), o que facilita a manutenção e a separação das responsabilidades:

model: Classes que representam as entidades (ex: Cliente.java, Produto.java) e a lógica de negócio.

dao (Data Access Object): Classes responsáveis pela comunicação direta com o banco de dados (CRUD).

view: Telas e interfaces gráficas (.form ou código Swing/JavaFX).

controller: Lógica de controle que intermedia a View e o Model/DAO.

util: Classes auxiliares (ex: ConexaoDB.java, ValidadorCPF.java).

⚙️ Pré-requisitos
Antes de executar o projeto, você precisará ter instalado:

Java Development Kit (JDK) [Versão que você usou]

MySQL Server (ou utilizar um ambiente como XAMPP/WAMP/MAMP).

Um cliente MySQL (ex: MySQL Workbench) para executar o script de criação do banco.

A biblioteca MySQL Connector/J (arquivo .jar para conexão JDBC) configurada no Build Path do projeto.

🚀 Configuração e Execução
Siga os passos abaixo para rodar o projeto em sua máquina:

1. Clonar o Repositório
2. Configurar o Banco de Dados
Crie um novo banco de dados no seu MySQL (ex: mini_supermercado).

Execute o script SQL para a criação das tabelas. Você pode encontrá-lo em: [Caminho para o seu arquivo .sql, ex: /db/script_db.sql].

(Opcional): O script já insere um usuário Administrador inicial:

Usuário (Admin): admin

Senha: 12345

3. Configurar a Conexão no Java
Abra o projeto na sua IDE ([Sua IDE]).

Localize a classe de conexão com o banco de dados (geralmente util/ConexaoDB.java ou similar).

Atualize as credenciais do banco com as suas:

4. Executar o Projeto
Certifique-se de que o MySQL Server está em execução.

Execute a classe principal do projeto ([Nome da sua classe principal. Ex: Main.java]).

🗃️ Modelo de Dados (Estrutura Simplificada)
👨‍💻 Autor
Desenvolvido por: VICTOR SARTI
