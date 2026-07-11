# Random Word Generator Design

## Goal

Generate a word by walking through two-character substrings extracted from a word list.

## Rules

- The first character is the first character of a source word.
- Every adjacent two-character substring occurs in at least one source word.
- A result is valid only when its last character is the last character of a source word.
- Generation stops after at most `maxLength` characters.
- During the walk, keep the most recent valid prefix and return it when generation stops.
- Return an empty string if no valid prefix of at least two characters was reached.

## Implementation

Add `src/exam/RandomWordGenerator.java`.

The constructor preprocesses the source words into:

- a list of valid starting characters;
- a set of valid ending characters;
- an adjacency map from a character to all characters that may follow it.

`generate(int maxLength)` selects a random starting character and performs a random walk through the adjacency map. Whenever the current word has a valid ending character, it records that prefix. It returns the latest recorded prefix after reaching `maxLength` or a character with no outgoing edge.

The class accepts a `Random` instance so callers can use normal randomness while `main` can use a fixed seed for reproducible examples.

## Validation

No separate test class is added. `main` runs examples with a fixed random seed and checks:

- the result does not exceed `maxLength`;
- its first and last characters are valid;
- each adjacent pair exists in the source word list;
- short or invalid inputs are handled without an infinite loop.
