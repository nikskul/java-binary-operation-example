# How binary operation in java work
## About application
The application demonstrate how binary operation work in Java.
### Binary "OR" and Binary "AND"
The binary OR(|) and binary AND(&) are pretty simple.

The OR operator compares each binary digit of two integers 
and gives back 1 if either of them is 1.

The AND operator compares each binary digit of two integers 
and gives back 1 if both are 1, otherwise it returns 0.

| X   | Y | X or Y | X and Y |
|-----|---|:------:|:-------:|
| 0   | 0 |   0    |    0    |
| 0   | 1 |   1    |    0    |
| 1   | 0 |   1    |    0    |
| 1   | 1 |   1    |    1    |

### Binary "XOR" and Compliment
The XOR(^) operator compares each binary digit of two integers 
and gives back 1 if both the compared bits are different.

The AND operator compares each binary digit of two integers 
and gives back 1 if both are 1, otherwise it returns 0.

| X   | Y | X ^ Y | ~X  |
|-----|---|:-----:|:---:|
| 0   | 0 |   1   |  1  |
| 0   | 1 |   1   |  1  |
| 1   | 0 |   1   |  0  |
| 1   | 1 |   0   |  0  |

### Binary "XOR" and Compliment
These may seem like the most complex of the operators and hard to understand, 
but they are easy to compare to multiplication and division by a power of 2.

Binary shift operators shift all the bits of the input value either to the left 
or right based on the shift operator.
```
/*******Signed Left Shift*******/
/* Equal multiplication by 2^n */
/*   0<<2 = 0*pow(2, 2) = 0    */
/*   1<<3 = 1*pow(2, 3) = 8    */
/*   3<<5 = 3*pow(2, 5) = 96   */
/*******************************/

/******Signed Right Shift*******/
/*    Equal division by 2^n    */
/*   0>>2 = 0/pow(2, 2) = 0    */
/*   4>>1 = 4/pow(2, 1) = 2    */
/*  64>>4 = 64/pow(2, 5) = 4   */
/*******************************/

/***********Unsigned Right Shift***********/
/*        Equal abs division by 2^n       */
/*        0>>>2 = 0/pow(2, 2) = 0         */
/*   -4>>>1 = -4/pow(2, 1) = 2147483646   */
/*  -64>>>4 = 64/pow(2, 5) = 268435452    */
/******************************************/
```

## Demonstration of application
```
(decimal) 0 = (binary) 0b0
(decimal) 1 = (binary) 0b1
(decimal) 3 = (binary) 0b11
(decimal) 3 = (binary) 0b11
(decimal) 5 = (binary) 0b101
(decimal) 7 = (binary) 0b111
/**************OR***************/
/*            0|0=0            */
/*            1|0=1            */
/*            1|1=1            */
/*******************************/
|--------------------------------------|
| int|int |   result |  binary|binary |
*   0&3   *     0b11 *    0b00|0b11    *
*   0&5   *    0b101 *   0b000|0b101   *
*   0&7   *    0b111 *   0b000|0b111   *
*   1&3   *     0b11 *    0b01|0b11    *
*   1&5   *    0b101 *   0b001|0b101   *
*   1&7   *    0b111 *   0b001|0b111   *
*   3&3   *     0b11 *    0b11|0b11    *
*   3&5   *    0b111 *   0b011|0b101   *
*   3&7   *    0b111 *   0b011|0b111   *
|--------------------------------------|
/**************AND**************/
/*            0&0=0            */
/*            1&0=0            */
/*            1&1=1            */
/*******************************/
|----------------------------------------|
| int&int |   result |   binary & binary |
*   0&3   *     0b00 *    0b00 & 0b11    *
*   0&5   *    0b000 *   0b000 & 0b101   *
*   0&7   *    0b000 *   0b000 & 0b111   *
*   1&3   *     0b01 *    0b01 & 0b11    *
*   1&5   *    0b001 *   0b001 & 0b101   *
*   1&7   *    0b001 *   0b001 & 0b111   *
*   3&3   *     0b11 *    0b11 & 0b11    *
*   3&5   *    0b001 *   0b011 & 0b101   *
*   3&7   *    0b011 *   0b011 & 0b111   *
|----------------------------------------|
/**************XOR**************/
/*            0^0=1            */
/*            1^0=1            */
/*            1^1=0            */
/*******************************/
|----------------------------------------|
| int^int |   result |   binary ^ binary |
*   0^3   *     0b11 *    0b00 ^ 0b11    *
*   0^5   *    0b101 *   0b000 ^ 0b101   *
*   0^7   *    0b111 *   0b000 ^ 0b111   *
*   1^3   *     0b10 *    0b01 ^ 0b11    *
*   1^5   *    0b100 *   0b001 ^ 0b101   *
*   1^7   *    0b110 *   0b001 ^ 0b111   *
*   3^3   *     0b00 *    0b11 ^ 0b11    *
*   3^5   *    0b110 *   0b011 ^ 0b101   *
*   3^7   *    0b100 *   0b011 ^ 0b111   *
|----------------------------------------|
/***********Compliment**********/
/*             ~0=1            */
/*             ~1=0            */
/*         ~0b101=0b010        */
/*******************************/
|--------------------------------------------------|
| int | int  | binary | binary | ~binary | ~binary |
*   0 * 3    *  0b000 * 0b011  *   0b111 *   0b100 *
*   0 * 5    *  0b000 * 0b101  *   0b111 *   0b010 *
*   0 * 7    *  0b000 * 0b111  *   0b111 *   0b000 *
*   1 * 3    *  0b001 * 0b011  *   0b110 *   0b100 *
*   1 * 5    *  0b001 * 0b101  *   0b110 *   0b010 *
*   1 * 7    *  0b001 * 0b111  *   0b110 *   0b000 *
*   3 * 3    *  0b011 * 0b011  *   0b100 *   0b100 *
*   3 * 5    *  0b011 * 0b101  *   0b100 *   0b010 *
*   3 * 7    *  0b011 * 0b111  *   0b100 *   0b000 *
|--------------------------------------------------|
/*******Signed Left Shift*******/
/* Equal multiplication by 2^n */
/*   0<<2 = 0*pow(2, 2) = 0    */
/*   1<<3 = 1*pow(2, 3) = 8    */
/*   3<<5 = 3*pow(2, 5) = 96   */
/*******************************/
|----------------------------------------------------------|
| int<<int | res |     binary << binary | result        |
*  32<<0   * 32  * 0b100000 << 0b000000 * 0b100000      *
*  32<<1   * 64  * 0b100000 << 0b000001 * 0b1000000     *
*  32<<4   * 512 * 0b100000 << 0b000100 * 0b1000000000  *
*  64<<0   * 64  * 0b1000000 << 0b0000000 * 0b1000000     *
*  64<<1   * 128 * 0b1000000 << 0b0000001 * 0b10000000    *
*  64<<4   * 1024 * 0b1000000 << 0b0000100 * 0b10000000000 *
* 114<<0   * 114 * 0b1110010 << 0b0000000 * 0b1110010     *
* 114<<1   * 228 * 0b1110010 << 0b0000001 * 0b11100100    *
* 114<<4   * 1824 * 0b1110010 << 0b0000100 * 0b11100100000 *
|----------------------------------------------------------|
/******Signed Right Shift*******/
/*    Equal division by 2^n    */
/*   0>>2 = 0/pow(2, 2) = 0    */
/*   4>>1 = 4/pow(2, 1) = 2    */
/*  64>>4 = 64/pow(2, 5) = 4   */
/*******************************/
|-------------------------------------------------------|
| int>>int | res |       binary >> binary | result      |
*  32>>0   * 32  *  0b100000 >> 0b000000  * 0b100000    *
*  32>>1   * 16  *  0b100000 >> 0b000001  * 0b010000    *
*  32>>4   * 2   *  0b100000 >> 0b000100  * 0b000010    *
*  64>>0   * 64  * 0b1000000 >> 0b0000000 * 0b1000000   *
*  64>>1   * 32  * 0b1000000 >> 0b0000001 * 0b0100000   *
*  64>>4   * 4   * 0b1000000 >> 0b0000100 * 0b0000100   *
* 114>>0   * 114 * 0b1110010 >> 0b0000000 * 0b1110010   *
* 114>>1   * 57  * 0b1110010 >> 0b0000001 * 0b0111001   *
* 114>>4   * 7   * 0b1110010 >> 0b0000100 * 0b0000111   *
|-------------------------------------------------------|
/***********Unsigned Right Shift***********/
/*        Equal abs division by 2^n       */
/*        0>>>2 = 0/pow(2, 2) = 0         */
/*   -4>>>1 = -4/pow(2, 1) = 2147483646   */
/*  -64>>>4 = 64/pow(2, 5) = 268435452    */
/******************************************/
|---------------------------------------------------------|
| int>>>int | res |       binary >>> binary | result      |
*  32>>>0   * 32  *  0b100000 >>> 0b000000  * 0b100000    *
*  32>>>1   * 16  *  0b100000 >>> 0b000001  * 0b010000    *
*  32>>>4   * 2   *  0b100000 >>> 0b000100  * 0b000010    *
*  64>>>0   * 64  * 0b1000000 >>> 0b0000000 * 0b1000000   *
*  64>>>1   * 32  * 0b1000000 >>> 0b0000001 * 0b0100000   *
*  64>>>4   * 4   * 0b1000000 >>> 0b0000100 * 0b0000100   *
* 114>>>0   * 114 * 0b1110010 >>> 0b0000000 * 0b1110010   *
* 114>>>1   * 57  * 0b1110010 >>> 0b0000001 * 0b0111001   *
* 114>>>4   * 7   * 0b1110010 >>> 0b0000100 * 0b0000111   *
|---------------------------------------------------------|
```
