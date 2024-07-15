package com.example.librarymanage.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.librarymanage.Entity.Author;
import com.example.librarymanage.Entity.Book;
import com.example.librarymanage.Entity.Publisher;
import com.example.librarymanage.R;
import com.example.librarymanage.Repository.AuthorRepository;
import com.example.librarymanage.Repository.BookRepository;
import com.example.librarymanage.Repository.PublisherRepository;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class UpdateBookActivity extends AppCompatActivity {

    private static boolean flag1 = false;
    private static boolean flag2 = false;

    private ImageView ivBack;
    private ImageView ivUpload;
    private Button btnUpdate;
    private TextInputLayout inputBookName;
    private TextInputLayout inputIntroduction;
    private TextInputLayout inputBorrowPrice;
    private TextInputLayout inputPublishingYear;
    private TextInputLayout inputQuantity;
    private TextInputLayout inputAuthor;
    private TextInputLayout inputPublisher;
    private Spinner spinnerCategory;
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_book);

        bookRepository = new BookRepository(getApplicationContext());
        authorRepository = new AuthorRepository(getApplicationContext());
        publisherRepository = new PublisherRepository(getApplicationContext());

        initView();

    }

    public void updateBook() {
        int categoryId = spinnerCategory.getSelectedItemPosition();

        String authorName = Objects.requireNonNull(inputAuthor.getEditText()).getText().toString().trim();
        int authorId = 0;
        if (isExistAuthor(authorRepository, authorName)) {
            authorId = authorRepository.getAuthorIdByName(authorName);
        } else {
            authorId = authorRepository.getLatestAuthorId() + 1;
            flag1 = true;
        }

        String publisherName = Objects.requireNonNull(inputPublisher.getEditText()).getText().toString().trim();
        int publisherId = 0;
        if (isExistPublisher(publisherRepository, authorName)) {
            publisherId = publisherRepository.getPublisherIdByName(publisherName);
        } else {
            publisherId = publisherRepository.getLatestPublisherId() + 1;
            flag2 = true;
        }

        String bookName = Objects.requireNonNull(inputBookName.getEditText()).getText().toString().trim();

        String image = "default_image"; // Hoặc cách lấy thông tin ảnh khác

        String introduction = Objects.requireNonNull(inputIntroduction.getEditText()).getText().toString().trim();

        String language = "English";

        int publishingYear = Integer.parseInt(Objects.requireNonNull(inputPublishingYear.getEditText()).getText().toString().trim());

        int quantity = Integer.parseInt(Objects.requireNonNull(inputQuantity.getEditText()).getText().toString().trim());

        int borrowPrice = Integer.parseInt(Objects.requireNonNull(inputBorrowPrice.getEditText()).getText().toString().trim());

        Book book = new Book(categoryId, authorId, publisherId, bookName,
                image, introduction, publishingYear, quantity, borrowPrice);
        Author author = new Author(authorId, authorName);
        Publisher publisher = new Publisher(publisherId, publisherName);

        bookRepository.createBook(book);
        if (flag1) authorRepository.insert(author);
        if (flag2) publisherRepository.insert(publisher);

        // Thực hiện các hành động khác với đối tượng Book (ví dụ: lưu vào database)
        Toast.makeText(this, "Book added: " + book.getBookName(), Toast.LENGTH_SHORT).show();
    }

    private void initView() {

        ivBack = findViewById(R.id.ivBack);
        ivUpload = findViewById(R.id.ivUpload);
        btnUpdate = findViewById(R.id.btnUpdate);
        inputBookName = findViewById(R.id.input_bookname);
        inputIntroduction = findViewById(R.id.input_introduction);
        inputBorrowPrice = findViewById(R.id.input_borrowPrice);
        inputPublishingYear = findViewById(R.id.input_publishingYear);
        inputQuantity = findViewById(R.id.input_quantity);
        inputAuthor = findViewById(R.id.input_author);
        inputPublisher = findViewById(R.id.input_publisher);
        spinnerCategory = findViewById(R.id.spinner_Category);

        // Tạo adapter cho Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Gắn adapter vào Spinner
        spinnerCategory.setAdapter(adapter);

        // Thiết lập sự kiện khi chọn mục trong Spinner
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String category = (String) parentView.getItemAtPosition(position);
                Toast.makeText(UpdateBookActivity.this, "Selected: " + category, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });

        ivBack.setOnClickListener(v -> onBackPressed());

        ivUpload.setOnClickListener(v -> showInputUrlDialog());

        btnUpdate.setOnClickListener(v -> updateBook());

    }

    private boolean isExistAuthor(AuthorRepository authorRepository, String author) {
        return ! (authorRepository.getAuthorIdByName(author) == null);
    }

    private boolean isExistPublisher(PublisherRepository publisherRepository, String publisher) {
        return ! (publisherRepository.getPublisherIdByName(publisher) == null);
    }

    private void showInputUrlDialog() {
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_TEXT_VARIATION_URI);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Image URL");
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String url = input.getText().toString().trim();
                if (!TextUtils.isEmpty(url)) {
                    Picasso.get().load(url).into(ivUpload);
                    Toast.makeText(UpdateBookActivity.this, "Upload successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}