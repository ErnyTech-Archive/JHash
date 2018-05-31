## JHash
JHash, an advanced Java (freedom) library for generate hash

JHash was created as a personal challenge to simplify hash generation in Java,
includes both synchronous and asynchronous api to allow the user to choose the most optimized according to need.

**Attention, this library only supports Java 10**

Hash algorithms currently supported:
  - Blake2b 160

  - Blake2b 256

  - Blake2b 384

  - Blake2b 512

  - Md2

  - Md5

  - Sha1

  - Sha256

  - Sha384

  - Sha512
  
## Examples

**Get SHA256 hash hex encoded of "hello" (Sync request)**
``` Java
var hex = new Sha256sum("Hello").getHex();
System.out.printf("%s\n", hex);
```

**Get Blake2B-384 hash hex encoded of file "/home/jhash/archlinux-2018.05.01-x86_64.iso" with java.nio (ASync request)**        
``` Java
var path = Paths.get("/home/jhash/archlinux-2018.05.01-x86_64.iso");
new JHash(new Blake2b384sum(path)).execute((hex, bytes) -> System.out.println(hex));
```  

**Get MD2 hash hex encoded of file "/home/jhash/archlinux-2018.05.01-x86_64.iso" (ASync request)**        
``` Java
var file = new File("/home/jhash/archlinux-2018.05.01-x86_64.iso");
new JHash(new Md2sum(file)).execute((hex, bytes) -> System.out.println(hex));
```  

**Get SHA-1 hash hex encoded of file "/home/jhash/archlinux-2018.05.01-x86_64.iso" (Sync request)**   
``` Java
var file = new File("/home/jhash/archlinux-2018.05.01-x86_64.iso");
System.out.println(new Sha1sum(file).getHex());
```  
  
## Copyright info
    JHash, an advanced Java (freedom) library for generate hash
    Copyright (C) 2018 Ernesto Castellotti

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as
    published by the Free Software Foundation, either version 3 of the
    License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this program.  If not, contact the owner of copyrights
    
# External Libraries used
  - BLAKE2b (https://github.com/rfksystems/blake2b)
    Copyright owner: rfksystems
    License: Apache License, Version 2.0
