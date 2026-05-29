# Sando-Nation 🥪

A point-of-sale console application for DELI-cious, a custom sandwich shop. Customers can fully customize their sandwich orders and the system generates a receipt for each completed order.

---

## Features

- Build a custom sandwich — choose size, bread, meat, cheese, toppings, sauces, and sides
- Order signature sandwiches with optional customization
- Add drinks and chips to your order
- Receipt generated automatically as a `.txt` file organized by date
- Input validation on every prompt

---

## How to Run

```bash
mvn compile exec:java -Dexec.mainClass="com.sando_nation.App"
```

Or run `App.java` directly from IntelliJ.

---

## Project Structure

```
src/
├── main/java/com/sando_nation/
│   ├── model/        # Business logic — Sandwich, Order, Menu, ingredients
│   ├── ui/           # Console screens and user interaction
│   ├── data/         # Receipt file handling
│   └── App.java      # Entry point
└── test/java/com/sando_nation/
    └── model/        # Unit tests
```

---

## Sandwich Pricing

| Size | Bread |
|---|---|
| 4 inch | $5.50 |
| 8 inch | $7.00 |
| 12 inch | $8.50 |

| Topping | 4" | 8" | 12" |
|---|---|---|---|
| Meat | $1.00 | $2.00 | $3.00 |
| Extra Meat | +$0.50 | +$1.00 | +$1.50 |
| Cheese | $0.75 | $1.50 | $2.25 |
| Extra Cheese | +$0.30 | +$0.60 | +$0.90 |

Regular toppings, sauces, and sides are included at no extra charge.

---

## Technologies

- Java 17
- Maven
- JUnit 5

---

## Author

Naod Asmelash — [naodd43@gmail.com](mailto:naodd43@gmail.com)
