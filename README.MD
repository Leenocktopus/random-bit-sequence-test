## Library of statistical tests for randomness

#### General 
The Library consists of 2 groups of tests developed for
the purpose of random number generators assessment.
Even though the main goal of this project was the development of 
tests for short sequences evaluation, it offers a full package of 
tests that can be used for sequences of arbitrary length. 

Technologies used: *JUnit.*

#### Statistical tests
Tests included in the project:
- 15 NIST tests described in the [NIST STS publication](https://csrc.nist.gov/projects/random-bit-generation/documentation-and-software).
NIST tests are useful when the length of a sequence is at least 100 bits.

- 8 Multidimensional statistics tests based on the papers of [S.Popereshnyak](https://ieeexplore.ieee.org/abstract/document/9088530). 
These tests are ought to be used only when the length of a sequence is in the range between 0 and 100.
