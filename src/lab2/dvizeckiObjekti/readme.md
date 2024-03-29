# Движечки објекти

Да се дефинира интерфејс `Movable` што ќе ги дефинира основните својства на еден движечки објект:

- движење нагоре (`void moveUp()`)
- движење надолу (`void moveLeft()`)
- движење надесно (`void moveRight()`)
- движење налево (`void moveLeft()`)
- пристап до моменталните x,y координати на објектот (`int getCurrentXPosition()` и `int getCurrentYPosition()`).

Постојат два типа на движечки објекти: движечка точка (`MovingPoint`) и движечки круг (`MovingCircle`). Да се дефинираат
овие две класи коишто го имплементираат интерфејсот `Movable`.

Во класата `MovingPoint` се чуваат информации за:

- x и y координати (цели броеви)
- `xSpeed` и `ySpeed` : степенот на поместување на движечката точка во x насока и y насока (цели броеви)

За класата да се имплементираат:

- конструктор со аргументи: `MovablePoint(int x, int y, int xSpeed, int ySpeed)`,
- методите наведени во интерфејсот `Movable`
- `toString` метод кој дава репрезентација на објектите во следнот формат `Movable point with coordinates (5,35)`

Во класата `MovingCircle` се чуваат информации за:

- радиусот на движечкиот круг (цел број)
- центарот на движечкиот круг (објект од класата `MovingPoint`).

За класата да се имплементираат:

- конструктор со аргументи: `MovableCircle(int radius, MovablePoint center)`
- методите наведени во интерфејсот `Movable`
- `toString` метод којшто дава репрезентација на објектите во следниот формат `Movable circle with center coordinates (
  48,21) and radius 3`

Првите четири методи од `Movable` (`moveUp`, `modeDown`, `moveRight`, `moveLeft`) треба да фрлат исклучок од тип
`ObjectCanNotBeMovedException` доколку придвижувањето во соодветната насока не е возможно, односно со придвижувањето се
излегува од дефинираниот простор во класата `MovablesCollection`. Справете се со овие исклучоци на соодветните места.
_Погледнете во тест примерите какви пораки треба да се печатат кога ќе се фати исклучок од овој тип и имплементирајте го
истото._

Да се дефинира класа `MovablesCollection` во која што ќе се чуваат информации за:

- низа од движечки објекти (`Movable [] movable`)
- статичка променлива за максималната вредност на координатата X (минималната е предодредена на 0)
- статичка променлива за максималната вредност на координатата Y (минималната е предодредена на 0)

За класата да се имплементираат следните методи:

- конструктор `MovablesCollection(int x_MAX, int y_MAX)`
- `void addMovableObject(Movable m)` - метод за додавање на движечки објект во колекцијата од сите движечки објекти.
  Пред да се додади објектот, мора да се провери дали истиот е може да се вклопи во дефинираниот простор, односно истиот
  да не излегува од границите `0-X_MAX` за x координатата и `0-Y_MAX` за y координатата. Доколку станува збор за
  движечки круг, потребно е целиот круг да се наоѓа во наведениот интервал на вредности. Доколку движечкиот објект не
  може да биде вклопен во просторот, да се фрли исклучок од тип `MovableObjectNotFittableException`. Потребно е да се
  справите со исклучокот на соодветното место во main методот. _Погледнете во тест примерите какви пораки треба да се
  печатат кога ќе се фати исклучок од овој тип и имплементирајте го истото._
- `void moveObjectsFromTypeWithDirection (TYPE type, DIRECTION direction)` - метод за придвижување на движечките објекти
  од тип `type` во насока `direction`. `TYPE` и `DIRECTION` се енумерации кои се задедени во почетниот код. Во зависност
  од насоката зададена во аргументот, да се повика соодветниот метод за придвижување.
- `toString()` - метод кој дава репрезентација на колекцијата од движечки објекти во следниот
  формат: `Collection of movable objects with size [големина на колекцијата]:` , по што во нов ред следуваат информации
  за сите движечки објекти во колекцијата.