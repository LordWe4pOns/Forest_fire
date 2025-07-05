# Forest fire
Simulation of the spreading of a forest fire, written in Java

A `T` represents a tree, a `X` represents a tree that's on fire and a `_` represents a tree's ashes

## Installation

### Downloading the project

- Option 1 :
```bash
git clone https://github.com/LordWe4pOns/Forest_fire.git
```

- Option 2 : Download the ZIP archive and extract it

### Compiling the project

The following actions should be performed from a bash terminal, in the `src` directory :

```bash
chmod +x compile.sh
./compile.sh
```

## Configuration

The `config.json` file allows you to define the following parameters :
- height of the forest (if not > 0, a default parameter will be chosen instead)
- width of the forest (if not > 0, a default parameter will be chosen instead)
- the probability that a fire spreads from one tree to its neighbor (if not bewteen 0 and 1, a default parameter will be chosen instead)
- the width and height coordinates, respectively named `x` and `y`, of the trees that are on fire at the beginning of the program

## Launching the project

After compiling, run these commands (still in the `src` directory) :

```bash
chmod +x run.sh
./run.sh
```