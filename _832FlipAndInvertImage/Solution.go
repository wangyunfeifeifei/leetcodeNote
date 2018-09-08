package main

func flipAndInvertImage(A [][]int) [][]int {
	for _, arr := range A {
		reverse(arr)
		for i := 0; i < len(arr); i++ {
			if arr[i] == 0 {
				arr[i] = 1
			} else {
				arr[i] = 0
			}
		}
	}

	return A
}

func reverse(arr []int) {
	l := len(arr) - 1
	for i := 0; i < l; i++ {
		tmp := arr[i]
		arr[i] = arr[l]
		arr[l] = tmp
		l--
	}
}

func main() {

}
