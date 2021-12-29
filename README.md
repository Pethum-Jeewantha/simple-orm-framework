# ORM Framework

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>

## About The Project

* This repository is a Simple ORM Framework.
* You can easily create a table without any sql coding.

## Getting Started

### Installation

1. First clone the repository.

   `git clone https://github.com/Pethum-Jeewantha/simple-orm-framework.git`

2. Once cloned, open the repository from the IntelliJ IDEA

3. Then package and Inject to a project as a dependency!

4. Create a class with relevant attributes which is you want to create a table.

5. Annotate the class with `@Table()` annotation & give it the value. The value represent the table name of the
   database.

6. Annotate the attributes with `@Column()` annotation which is you wish to add column & give it column name as the
   annotation value.

7. Annotate the attribute with `@Embed` annotation which is you wish to add columns from another class. The nested class
   should haven't `@id` annotation.

8. You can annotate an attribute as primary key by using `@Id` annotation.

9. Now you can use this as a dependency by using `init` method. Pass the parameters of your connection & Table class.

## Usage

* You can use this to create database table without any sql coding.

## License

Copyright &copy; 2021 - present Pethum Jeewantha. All rights reserved.

Licensed under the [MIT](LICENSE.txt) license.

## Contact

Pethum Jeewantha - [Twitter](https://twitter.com/JeewanthaPethum?s=08) - pethumjeewantha4@gmail.com

[Project](https://github.com/Pethum-Jeewantha/simple-orm-framework)

## Acknowledgements

* [Img Shields](https://shields.io)
* [Choose an Open Source License](https://choosealicense.com)

[contributors-shield]: https://img.shields.io/github/contributors/Pethum-Jeewantha/simple-orm-framework.svg?style=for-the-badge

[contributors-url]: https://https://github.com/Pethum-Jeewantha/simple-orm-framework/graphs/contributors

[forks-shield]: https://img.shields.io/github/forks/Pethum-Jeewantha/simple-orm-framework.svg?style=for-the-badge

[forks-url]: https://github.com/Pethum-Jeewantha/simple-orm-framework/network/members

[stars-shield]: https://img.shields.io/github/stars/Pethum-Jeewantha/simple-orm-framework.svg?style=for-the-badge

[stars-url]: https://https://github.com/Pethum-Jeewantha/simple-orm-framework/stargazers

[license-shield]: https://img.shields.io/github/license/Pethum-Jeewantha/simple-orm-framework.svg?style=for-the-badge

[license-url]: https://https://github.com/Pethum-Jeewantha/simple-orm-framework/blob/master/LICENSE

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555

[linkedin-url]: https://www.linkedin.com/in/pethum-jeewantha-7b70aa1b1
