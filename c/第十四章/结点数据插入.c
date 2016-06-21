b.next=a.next;//a.next指向c的地址。插入时应该是b先指向c（b.next指向C的地址哦，，这时a和b的指针都指向c的地址），
             //不能a先指向b，因为会丢失c的地址
a.next=&b;
