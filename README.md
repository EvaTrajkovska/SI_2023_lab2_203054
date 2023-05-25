## Втора лабораториска вежба по Софтверско инженерство

### Ева Трајковска, бр. на индекс 203054
#

### Control Flow Graph


![CFG](https://github.com/EvaTrajkovska/SI_2023_lab2_203054/assets/118076394/17986021-ea98-4314-8f53-927d4255a830)


### Цикломатска комплексност
Цикломатската комплексност на овој код е 10, истата ја добив преку формулата E-N+2, каде што E е бројот на ребра, а N е бројот на јазли. Во случајoв Е=36, N=28, па цикломатската комплексност изнесува 8+2=10.

### Тест случаи според критериумот Every Branch
- User null  => исполнет е првиот услов **TXX**
- User ("john", "Password123!", "john@gmail.com") => password има специјален знак и нема празно место
- User("jane", "Password ?", "jane@gmail.com") => password има специјален знак и има празно место
- User("karl", "karl", "karl@gmailcom") => user со ист password и username и без точка во username
- User("lora", "Pass", "lora@gmail.com") => user за кој проверуваме дупликат password и email 
- User("ann", "Password123??", "ann@gmail.com") => нов user за кој програмата враќа TRUE


### Тест случаи според критериумот Multiple Condition за условот if (user==null || user.getPassword()==null || user.getEmail()==null)
- User null  => исполнет е првиот услов **TXX**
- User("kate", null, "smith@gmail.com")  => исполнет е вториот услов  **FTX**
- User("jade", "Password???", null)  => исполнет е третиот услов **FFT**
- User("ann", "Password123??", "ann@gmail.com") => не е исполнет ниту еден од условите **FFF**
