#  ✂️ Blades & Bytes - Website de Agendamento de Barbearia ✂️ 

# Introdução :
O projeto Blades & Bytes é um sistema web desenvolvido para facilitar o agendamento de serviços em barbearias.
 Com ele, clientes podem marcar horários com barbeiros de forma prática e rápida, enquanto os administradores gerenciam os cadastros de clientes, profissionais e serviços oferecidos.
 Construído em Java utilizando Spring Boot, o sistema integra conceitos de banco de dados, engenharia de software e desenvolvimento web para entregar uma solução eficiente e acessível.

Este projeto contém o código e os materiais relacionados a um projeto interdisciplinar desenvolvido no âmbito das disciplinas de Estatística, Linguagem de Programação II, Adm. Banco de Dados e Gestão da Qualidade Ambiental, do curso de Informática para Negócios.
 O projeto tem como objetivo integrar os conceitos e técnicas abordados nessas disciplinas para desenvolver um website em Java, focado no agendamento de serviços de barbearia.

## Objetivo

O objetivo principal deste projeto é criar um sistema de agendamento para barbearias que permita aos clientes marcar horários para serviços de corte de cabelo, barba e outros serviços oferecidos.
 Além disso, o sistema permite o cadastro de profissionais.

## Funcionalidades

## Cadastro de Profissionais - 
 Permite que novos barbeiros sejam cadastrados no sistema.

## Agendamento de Serviços:
 Clientes podem agendar serviços com os funcionários disponíveis.

## Visualização de Agendamentos:
 Funcionalidade para visualizar os agendamentos realizados.


## Tecnologias Utilizadas
Java 11+: Linguagem principal para desenvolvimento do backend.

## Spring Boot: 
Framework para construção do aplicativo web, facilitando a configuração e o desenvolvimento.

## Spring MVC: 
Para o padrão Model-View-Controller na aplicação.

## Spring Data JPA:
 Para interação com o banco de dados usando JPA/Hibernate.

## Banco de Dados MySQL:
 Armazenamento dos dados de usuários, serviços e agendamentos.

## HTML, CSS e Thymeleaf:
 Para construção das páginas web e integração dinâmica com o backend.

## Maven: 
Para gerenciamento de dependências e build do projeto.

## Estrutura do Projeto
src/main/java/model: Contém as classes que representam as entidades principais do sistema. Cada classe contém atributos que descrevem as propriedades das entidades e métodos para manipular esses dados.

src/main/resources/templates: Arquivos HTML usados como views, utilizando Thymeleaf para renderização dinâmica.

src/main/resources/static: Arquivos estáticos como CSS, imagens e scripts JavaScript.

src/main/java/controller: Classes responsáveis por controlar o fluxo das requisições, conectar o backend com as views e manipular dados via serviços.

src/main/java/service: Contém as regras de negócio da aplicação, manipulando dados entre os controllers e os repositórios.

src/main/java/repository: Interfaces que fazem a comunicação com o banco de dados, usando Spring Data JPA.


## Como Rodar o Projeto
Pré-requisitos
Java JDK 11 ou superior instalado.

Maven instalado.

MySQL instalado e configurado.

IDE (Visual Studio Code, IntelliJ IDEA ou Eclipse) .

## Autores 

Murilo Henrique Santos de Oliveira
Gabriela Santos Ortis
Lucas Grebalos deSouza

